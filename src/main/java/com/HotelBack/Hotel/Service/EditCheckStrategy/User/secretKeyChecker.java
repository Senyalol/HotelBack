package com.HotelBack.Hotel.Service.EditCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Entity.UserRole;
import com.HotelBack.Hotel.Repository.UserRoleRepository;

public class secretKeyChecker implements EditUserCheck{

    private final UserRoleRepository userRoleRepository;
    private String secretKey;

    public secretKeyChecker(UserRoleRepository userRoleRepository, String secretKey) {
        this.userRoleRepository = userRoleRepository;
        this.secretKey = secretKey;
    }

    @Override
    public void check(UserDTO userDTO, User user) {

        if(userDTO != null && userDTO.getSecretKey() != null){

            UserRole userRole = userRoleRepository.findByUserId(user.getId());

            if(userDTO.getSecretKey().equals(secretKey)){
                userRole.setRole("ADMIN");
            }
            else if(!userDTO.getSecretKey().equals(secretKey)){
                userRole.setRole("USER");
            }

            userRoleRepository.save(userRole);
        }

    }

}
