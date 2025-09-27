package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class firstNameCreateChecker implements CreateUserCheck{

    @Override
    public boolean check(User user) {

        boolean result = true;
        if(user == null || user.getFirstName() == null){

            result = false;

        }

        return result;
    }
}
