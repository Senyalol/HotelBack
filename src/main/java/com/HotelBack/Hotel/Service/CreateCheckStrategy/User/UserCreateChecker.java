package com.HotelBack.Hotel.Service.CreateCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateChecker {

    private List<CreateUserCheck> checks;

    public UserCreateChecker(List<CreateUserCheck> checks) {
        this.checks = checks;
    }

    public boolean check(UserDTO userDTO){

        boolean result = true;
        for(CreateUserCheck check : checks){

            if(!check.check(userDTO)){
                result = false;
            }

        }
        return result;
    }

}
