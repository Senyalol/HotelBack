package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class passwordCreateChecker implements CreateUserCheck{

    @Override
    public boolean check(User user) {

        boolean result = true;
        if(user == null || user.getPassword() == null){

            result = false;

        }

        return result;
    }
}
