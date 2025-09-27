package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class avatarUserChecker implements EditUserCheck{

    @Override
    public void check(User updateUser, User user) {

        if(updateUser != null){

            if(updateUser.getAvatarUser() != null){

                user.setAvatarUser(updateUser.getAvatarUser());

            }

        }

    }
}
