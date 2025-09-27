package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//mport org.springframework.beans.factory.annotation.Autowired;

public class emailCreateChecker implements CreateUserCheck{

    private final UserRepository userRepository;

    public emailCreateChecker(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public boolean check(UserDTO userDTO) {

        boolean result = true;

        if(userDTO == null || userDTO.getEmail() == null){

            result = false;

        }
        //Проверка на уникальность Email
        else if(userRepository.findByEmail(userDTO.getEmail()) != null){

            result = false;

        }

        return result;
    }
}