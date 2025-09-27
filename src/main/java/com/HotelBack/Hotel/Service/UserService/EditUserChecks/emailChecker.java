package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;

public class emailChecker implements EditUserCheck{
    @Override
    public void check(UserDTO userDTO, User user) {

        if(userDTO != null){

            if(userDTO.getEmail() != null){

                user.setEmail(userDTO.getEmail());

            }

        }

    }
}
