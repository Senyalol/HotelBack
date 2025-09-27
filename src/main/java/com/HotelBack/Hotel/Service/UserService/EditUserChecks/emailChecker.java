package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class emailChecker implements EditUserCheck{

    @Override
    public void check(User updateUser, User user) {

        if(updateUser != null){

            if(updateUser.getEmail() != null){

                user.setEmail(updateUser.getEmail());

            }

        }

    }
}
