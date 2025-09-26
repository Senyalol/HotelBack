package com.HotelBack.Hotel.Service.CreateCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;

public class secretKeyCreateChecker implements CreateUserCheck{
    @Override
    public boolean check(UserDTO userDTO) {
        boolean result = true;

        if(userDTO == null || userDTO.getSecretKey() == null){
            result = false;
        }
        return result;
    }
}
