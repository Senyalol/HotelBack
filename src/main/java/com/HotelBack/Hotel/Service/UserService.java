package com.HotelBack.Hotel.Service;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Mapping.UserMapper;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Service.CreateCheckStrategy.User.*;
import com.HotelBack.Hotel.Service.EditCheckStrategy.User.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
//import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Метод регистрирующий пользователя в БД
    public UserDTO createUser(UserDTO userDTO) {

        List<CreateUserCheck> checks = Arrays.asList(
                new firstNameCreateChecker(),
                new lastNameCreateChecker(),
                new emailCreateChecker(userRepository,userMapper),
                new passwordCreateChecker()
        );

        UserCreateChecker userChecker = new UserCreateChecker(checks);

        if(userDTO != null || userChecker.check(userDTO)) {

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
        ,new lastNameChecker(), new emailChecker(), new passwordChecker());

        UserChecker userChecker = new UserChecker(checks);

        userChecker.check(userDTO, editableUser);

        return userMapper.EntityToDTO(userRepository.findById(id));

    }

}
