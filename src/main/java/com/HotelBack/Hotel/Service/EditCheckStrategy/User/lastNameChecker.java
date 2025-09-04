package com.HotelBack.Hotel.Service.EditCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;

public class lastNameChecker implements EditUserCheck{
    @Override
    public void check(UserDTO userDTO, User user) {

        if(userDTO != null){

            if(userDTO.getLastname() != null){

                user.setLastName(userDTO.getLastname());

            }

        }

    }
}
