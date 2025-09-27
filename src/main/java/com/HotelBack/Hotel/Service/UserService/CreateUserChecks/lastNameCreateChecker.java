package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class lastNameCreateChecker implements CreateUserCheck{

    @Override
    public boolean check(User user) {

        boolean result = true;
        if(user == null || user.getLastName() == null){
            result = false;
        }

        return result;
    }
}
