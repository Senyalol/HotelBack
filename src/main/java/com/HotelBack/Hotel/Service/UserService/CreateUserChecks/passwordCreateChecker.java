package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.DTO.UserDTO;

public class passwordCreateChecker implements CreateUserCheck{



    @Override
    public boolean check(UserDTO userDTO) {

        boolean result = true;
        if(userDTO == null || userDTO.getPassword() == null){

            result = false;

        }

        return result;
    }
}
