package com.HotelBack.Hotel.Service.EditCheckStrategy.User;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;

public interface EditUserCheck {

    void check(UserDTO userDTO, User user);

}
