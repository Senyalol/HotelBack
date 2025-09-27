package com.HotelBack.Hotel.Service.UserService;

import com.HotelBack.Hotel.Entity.SecurityEntity.JwtAuthentication;
import com.HotelBack.Hotel.Entity.SecurityEntity.JwtToken;
import com.HotelBack.Hotel.Entity.SecurityEntity.RefreshToken;
import com.HotelBack.Hotel.Entity.SecurityEntity.UserCredential;
import com.HotelBack.Hotel.Entity.User;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UserService {

    User findUser(int id);

    void deleteYourUser(JwtToken jwt);

    User getYourself(JwtToken jwt);

    User updateYourSelf(String authHeader,User user);

    User createUser(User user);

    List<User> getAllUsers();

    void deleteUser(int userId);

    User updateUser(int id,User user);

    JwtAuthentication signIn(UserCredential userCredential);

    JwtAuthentication refreshToken(RefreshToken refreshToken) throws AuthenticationException;

}
