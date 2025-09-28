package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;

public class secretKeyChecker implements EditUserCheck{

    private String secretKey;

    public secretKeyChecker(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public void check(User updateUser, User user) {

        if(updateUser != null && updateUser.getSecretkey() != null){
            //UserRole userRole = userRoleRepository.findByUserId(user.getId());

            if(updateUser.getSecretkey().equals(secretKey)){
                user.setRole("ADMIN");
            }
            else if(!updateUser.getSecretkey().equals(secretKey)){
                user.setRole("USER");
            }

        }

    }

}
