package com.HotelBack.Hotel.Service.EditCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class passwordChecker implements EditUserCheck{

    private final PasswordEncoder passwordEncoder;

    public passwordChecker(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void check(UserDTO userDTO, User user) {

        if(userDTO != null){

            if(userDTO.getPassword() != null){

                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            }

        }

    }
}
