package com.HotelBack.Hotel.Service.CreateCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Mapping.UserMapper;
import com.HotelBack.Hotel.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//mport org.springframework.beans.factory.annotation.Autowired;

public class emailCreateChecker implements CreateUserCheck{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public emailCreateChecker(UserRepository userRepository, UserMapper userMapper) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean check(UserDTO userDTO) {

        boolean result = true;

        if(userDTO == null || userDTO.getEmail() == null){

            result = false;

        }
        //Проверка на уникальность Email
        else if(userRepository.findByEmail(userDTO.getEmail()) == null){

            result = false;

        }

        return result;
    }
}