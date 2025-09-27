package com.HotelBack.Hotel.Service.UserService.EditUserChecks;

import com.HotelBack.Hotel.Entity.User;

public interface EditUserCheck {

    void check(User updateUser, User oldUserData);

}
