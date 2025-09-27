package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class passwordChecker implements EditUserCheck{

    private final PasswordEncoder passwordEncoder;

    public passwordChecker(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void check(User updateUser, User user) {

        if(updateUser != null){

            if(updateUser.getPassword() != null){

                user.setPassword(passwordEncoder.encode(updateUser.getPassword()));

            }

        }

    }
}
