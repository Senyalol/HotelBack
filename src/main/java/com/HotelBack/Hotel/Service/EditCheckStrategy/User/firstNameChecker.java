package com.HotelBack.Hotel.Service.EditCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;

public class firstNameChecker implements EditUserCheck{

    @Override
    public void check(UserDTO userDTO, User user) {

        if(userDTO != null){

            if(userDTO.getFirstname() != null){

                user.setFirstName(userDTO.getFirstname());

            }

        }

    }

}
