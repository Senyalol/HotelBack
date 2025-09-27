package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;

public interface EditUserCheck {

    void check(UserDTO userDTO, User user);

}
