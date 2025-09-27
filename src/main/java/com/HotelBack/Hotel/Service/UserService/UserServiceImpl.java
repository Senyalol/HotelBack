package com.HotelBack.Hotel.Service.UserService;

import com.HotelBack.Hotel.DTO.UserDTO;
//import com.HotelBack.Hotel.Entity.Booking;
//import com.HotelBack.Hotel.Entity.Review;
import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Entity.UserRole;
import com.HotelBack.Hotel.Mapping.UserMapper;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Repository.UserRoleRepository;
import com.HotelBack.Hotel.Security.JWTService;
import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.RefreshTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.UserCredentialDTO;
import com.HotelBack.Hotel.Service.UserService.CreateUserChecks.*;
import com.HotelBack.Hotel.Service.UserService.EditUserChecks.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@JsonSerialize
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final UserRoleRepository userRoleRepository;

    @Value("${app.admin_key}")
    private String adminKey;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, JWTService jwtService, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userRoleRepository = userRoleRepository;
    }

    //Найти по id пользователя
    @Override
    public UserDTO findUser(int id){

        User user = userRepository.findById(id);

        return userMapper.EntityToDTO(user);

    }

    //Удалить свой аккаунт
    @Override
    public void deleteYourUser(JwtTokenDTO jwtDTO){
        userRepository.deleteUserByEmail(jwtService.parseTokenForEmail(jwtDTO).getEmail());
    }

    //Посмотреть свои данные
    @Override
    public UserDTO getYourself(JwtTokenDTO jwtDTO){
       return userMapper.EntityToDTO(userRepository.findByEmail(jwtService.parseTokenForEmail(jwtDTO).getEmail()));
    }

    @Override
    public UserDTO updateYourSelf(String authHeader,UserDTO userDTO){

        String jwtToken = authHeader.substring(7);
        String email = jwtService.getEmailFromToken(jwtToken);
        User editableUser = userRepository.findByEmail(email);

        List<EditUserCheck> checks = Arrays.asList(
                new firstNameChecker(),
                new lastNameChecker(),
                new emailChecker(),
                new passwordChecker(passwordEncoder),
                new avatarUserChecker(),
                new secretKeyChecker(userRoleRepository,adminKey)
        );

        UserChecker userChecker = new UserChecker(checks);

        if(userDTO !=null){

            userChecker.check(userDTO,editableUser);
            userRepository.save(editableUser);
        }

        return userMapper.EntityToDTO(userRepository.findByEmail(email));

    }

    //Метод регистрирующий пользователя в БД
    @Override
    public UserDTO createUser(UserDTO userDTO) {

        List<CreateUserCheck> checks = Arrays.asList(
                new firstNameCreateChecker(),
                new lastNameCreateChecker(),
                new emailCreateChecker(userRepository),
                new passwordCreateChecker(),
                new avatarUserCreateChecker(),
                new secretKeyCreateChecker()
        );

        UserCreateChecker userChecker = new UserCreateChecker(checks);

        if(userDTO != null && userChecker.check(userDTO)) {

            try {
                User savedUser = userMapper.DTOToEntity(userDTO);
                savedUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                userRepository.save(savedUser);

                UserRole newUserRole = new UserRole();
                newUserRole.setUser(userRepository.findByEmail(userDTO.getEmail()));

                if(userDTO.getSecretKey().equals(adminKey)){

                         newUserRole.setRole("ADMIN");

                }

                else if(!userDTO.getSecretKey().equals(adminKey)){
                    newUserRole.setRole("USER");
                }

                userRoleRepository.save(newUserRole);

                return userDTO;
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return null;
    }

    //Метод выводящий всех пользователей
    @Override
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> userMapper.EntityToDTO(user))
                .collect(Collectors.toList());

    }

    //Метод удаляющий пользователя по его id
    @Transactional
    @Override
    public void deleteUser(int userId) {

        try {

            userRepository.deleteById(userId);


        }
        catch(Exception e) {
            throw new RuntimeException("Failed to delete user");
        }

    }

    @Override
    public UserDTO updateUser(int id,UserDTO userDTO) {

        User editableUser = userRepository.findById(id);

        List<EditUserCheck> checks = Arrays.asList(new firstNameChecker()
        ,new lastNameChecker(), new emailChecker(), new passwordChecker(passwordEncoder)
        ,new avatarUserChecker(), new secretKeyChecker(userRoleRepository,adminKey));

        UserChecker userChecker = new UserChecker(checks);

        userChecker.check(userDTO, editableUser);

        return userMapper.EntityToDTO(userRepository.findById(id));

    }

    @Override
    public JwtAuthenticationDTO signIn(UserCredentialDTO userCredentialDTO) {

        User user = userRepository.findByEmail(userCredentialDTO.getEmail());

        if(userCredentialDTO.getEmail() != null && userCredentialDTO.getPassword() != null) {

            if(userCredentialDTO.getEmail().equals(user.getEmail()) && passwordEncoder.matches(userCredentialDTO.getPassword(), user.getPassword())) {
                return jwtService.getTokenForUser(user.getEmail());
            }

            else{
                System.out.println("Incorrect authentification data");
            }

        }
        else{
            System.out.println("Incorrect email or password");
        }

        return null;
    }

    @Override
    public JwtAuthenticationDTO refreshToken(RefreshTokenDTO refreshTokenDTO) throws AuthenticationException {

        String refreshToken = refreshTokenDTO.getRefreshToken();
        if(refreshToken != null && jwtService.validateJwtToken(refreshToken)) {

            try{

                User user = findByEmail(jwtService.getEmailFromToken(refreshToken));
                return jwtService.generateRefreshToken(user.getEmail(),refreshToken);

            }
            catch(Exception e) {
                throw new AuthenticationException("User not found: " + e.getMessage());
            }

        }
        throw new AuthenticationException("Invalid refresh token");
    }

    private User findByEmail(String email) throws Exception{

        return userRepository.findByEmail(email);

    }

}
