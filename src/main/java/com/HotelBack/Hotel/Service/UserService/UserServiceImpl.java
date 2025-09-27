package com.HotelBack.Hotel.Service.UserService;

import com.HotelBack.Hotel.Entity.SecurityEntity.JwtAuthentication;
import com.HotelBack.Hotel.Entity.SecurityEntity.JwtToken;
import com.HotelBack.Hotel.Entity.SecurityEntity.RefreshToken;
import com.HotelBack.Hotel.Entity.SecurityEntity.UserCredential;
import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Entity.UserRole;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Repository.UserRoleRepository;
import com.HotelBack.Hotel.Security.JWTService;
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

@Service
@Transactional
@JsonSerialize
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final UserRoleRepository userRoleRepository;

    @Value("${app.admin_key}")
    private String adminKey;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTService jwtService, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userRoleRepository = userRoleRepository;
    }

    //Найти по id пользователя
    @Override
    public User findUser(int id){
        return userRepository.findById(id);
    }

    //Удалить свой аккаунт
    @Override
    public void deleteYourUser(JwtToken jwt){
        userRepository.deleteUserByEmail(jwtService.parseTokenForEmail(jwt).getEmail());
    }

    //Посмотреть свои данные
    @Override
    public User getYourself(JwtToken jwt){
       return userRepository.findByEmail(jwtService.parseTokenForEmail(jwt).getEmail());
    }

    @Override
    public User updateYourSelf(String authHeader,User user){

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

        if(user !=null){

            userChecker.check(user,editableUser);
            userRepository.save(editableUser);
        }

        return userRepository.findByEmail(email);

    }

    //Метод регистрирующий пользователя в БД
    @Override
    public User createUser(User savedUser) {

        List<CreateUserCheck> checks = Arrays.asList(
                new firstNameCreateChecker(),
                new lastNameCreateChecker(),
                new emailCreateChecker(userRepository),
                new passwordCreateChecker(),
                new avatarUserCreateChecker(),
                new secretKeyCreateChecker()
        );

        UserCreateChecker userChecker = new UserCreateChecker(checks);

        if(savedUser != null && userChecker.check(savedUser)) {

            try {
                savedUser.setPassword(passwordEncoder.encode(savedUser.getPassword()));
                userRepository.save(savedUser);

                UserRole newUserRole = new UserRole();
                newUserRole.setUser(userRepository.findByEmail(savedUser.getEmail()));

                if(savedUser.getSecretkey().equals(adminKey)){

                    newUserRole.setRole("ADMIN");

                }

                else if(!savedUser.getSecretkey().equals(adminKey)){
                    newUserRole.setRole("USER");
                }

                userRoleRepository.save(newUserRole);

                return savedUser;
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return null;
    }

    //Метод выводящий всех пользователей
    @Override
    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users;

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
    public User updateUser(int id,User user) {

        User editableUser = userRepository.findById(id);

        List<EditUserCheck> checks = Arrays.asList(new firstNameChecker()
        ,new lastNameChecker(), new emailChecker(), new passwordChecker(passwordEncoder)
        ,new avatarUserChecker(), new secretKeyChecker(userRoleRepository,adminKey));

        UserChecker userChecker = new UserChecker(checks);

        userChecker.check(user, editableUser);

        return userRepository.findById(id);

    }

    @Override
    public JwtAuthentication signIn(UserCredential userCredential) {

        User user = userRepository.findByEmail(userCredential.getEmail());

        if(userCredential.getEmail() != null && userCredential.getPassword() != null) {

            if(userCredential.getEmail().equals(user.getEmail()) && passwordEncoder.matches(userCredential.getPassword(), user.getPassword())) {
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
    public JwtAuthentication refreshToken(RefreshToken refreshTokenEntity) throws AuthenticationException {

        String refreshToken = refreshTokenEntity.getRefreshToken();
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
