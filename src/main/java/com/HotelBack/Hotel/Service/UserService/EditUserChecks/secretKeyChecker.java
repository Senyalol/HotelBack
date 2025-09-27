package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

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
    public void check(User updateUser, User user) {

        if(updateUser != null && updateUser.getSecretkey() != null){

            UserRole userRole = userRoleRepository.findByUserId(user.getId());

            if(updateUser.getSecretkey().equals(secretKey)){
                userRole.setRole("ADMIN");
            }
            else if(!updateUser.getSecretkey().equals(secretKey)){
                userRole.setRole("USER");
            }

            userRoleRepository.save(userRole);
        }

    }

}
