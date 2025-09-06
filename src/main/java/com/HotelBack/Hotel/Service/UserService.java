package com.HotelBack.Hotel.Service;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Mapping.UserMapper;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Security.JWTService;
import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.RefreshTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.UserCredentialDTO;
import com.HotelBack.Hotel.Service.CreateCheckStrategy.User.*;
import com.HotelBack.Hotel.Service.EditCheckStrategy.User.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
//import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@JsonSerialize
//@Data
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    //Метод регистрирующий пользователя в БД
    public UserDTO createUser(UserDTO userDTO) {

        List<CreateUserCheck> checks = Arrays.asList(
                new firstNameCreateChecker(),
                new lastNameCreateChecker(),
                new emailCreateChecker(userRepository),
                new passwordCreateChecker()
        );

        UserCreateChecker userChecker = new UserCreateChecker(checks);

        if(userDTO != null && userChecker.check(userDTO)) {

            try {
                userRepository.save(userMapper.DTOToEntity(userDTO));

                return userDTO;
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return null;
    }

    //Метод выводящий всех пользователей
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> userMapper.EntityToDTO(user))
                .collect(Collectors.toList());

    }

    //Метод удаляющий пользователя по его id
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public UserDTO updateUser(int id,UserDTO userDTO) {

        User editableUser = userRepository.findById(id);

        List<EditUserCheck> checks = Arrays.asList(new firstNameChecker()
        ,new lastNameChecker(), new emailChecker(), new passwordChecker(passwordEncoder));

        UserChecker userChecker = new UserChecker(checks);

        userChecker.check(userDTO, editableUser);

        return userMapper.EntityToDTO(userRepository.findById(id));

    }

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
