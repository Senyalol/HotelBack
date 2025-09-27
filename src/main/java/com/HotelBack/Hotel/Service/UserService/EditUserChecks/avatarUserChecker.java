package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;

public class avatarUserChecker implements EditUserCheck{
    @Override
    public void check(UserDTO userDTO, User user) {

        if(userDTO != null){

            if(userDTO.getAvatarUser() != null){

                user.setAvatarUser(userDTO.getAvatarUser());

            }

        }

    }
}
