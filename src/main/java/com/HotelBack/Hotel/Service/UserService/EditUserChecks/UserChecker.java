package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserChecker {

    private List<EditUserCheck> userChecks;

    public UserChecker(List<EditUserCheck> userChecks) {
        this.userChecks = userChecks;
    }

    public void check(User updateUser, User user){

        for(EditUserCheck check : userChecks){

            check.check(updateUser, user);

        }

    }

}
