package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class firstNameChecker implements EditUserCheck{

    @Override
    public void check(User updateUser, User user) {

        if(updateUser != null){

            if(updateUser.getFirstName() != null){

                user.setFirstName(updateUser.getFirstName());

            }

        }

    }

}
