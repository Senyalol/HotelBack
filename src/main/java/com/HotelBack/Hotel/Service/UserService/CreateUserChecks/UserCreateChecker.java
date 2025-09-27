package com.HotelBack.Hotel.Service.UserService.CreateUserChecks;

import com.HotelBack.Hotel.Entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateChecker {

    private List<CreateUserCheck> checks;

    public UserCreateChecker(List<CreateUserCheck> checks) {
        this.checks = checks;
    }

    public boolean check(User user){

        boolean result = true;
        for(CreateUserCheck check : checks){

            if(!check.check(user)){
                result = false;
            }

        }
        return result;
    }

}
