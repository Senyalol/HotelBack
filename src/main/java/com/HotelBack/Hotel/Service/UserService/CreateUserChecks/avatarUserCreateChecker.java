package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class avatarUserCreateChecker implements CreateUserCheck{
    @Override
    public boolean check(User user) {
        boolean result = true;

        if(user == null || user.getAvatarUser() == null){
            result = false;
        }

        return result;
    }
}
