package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Repository.UserRepository;

public class emailCreateChecker implements CreateUserCheck{

    private final UserRepository userRepository;

    public emailCreateChecker(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public boolean check(User user) {

        boolean result = true;

        if(user == null || user.getEmail() == null){

            result = false;

        }
        //Проверка на уникальность Email
        else if(userRepository.findByEmail(user.getEmail()) != null){

            result = false;

        }

        return result;
    }
}