package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class lastNameChecker implements EditUserCheck{

    @Override
    public void check(User updateUser, User user) {

        if(updateUser != null){

            if(updateUser.getLastName() != null){

                user.setLastName(updateUser.getLastName());

            }

        }

    }
}
