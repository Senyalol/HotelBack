package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.DTO.UserDTO;

public class lastNameCreateChecker implements CreateUserCheck{
    @Override
    public boolean check(UserDTO userDTO) {

        boolean result = true;
        if(userDTO == null || userDTO.getLastname() == null){
            result = false;
        }

        return result;
    }
}
