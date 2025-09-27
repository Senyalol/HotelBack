package com.HotelBack.Hotel.Security;

import com.HotelBack.Hotel.Entity.SecurityEntity.EmailFromToken;
import com.HotelBack.Hotel.Entity.SecurityEntity.JwtAuthentication;
import com.HotelBack.Hotel.Entity.SecurityEntity.JwtToken;

public interface JWTService {

    boolean validateJwtToken(String token);

    String generateJwtToken(String email, String role);

    JwtAuthentication getTokenForUser(String email);

    JwtAuthentication generateRefreshToken(String email, String refreshToken);

    String getEmailFromToken(String token);

    EmailFromToken parseTokenForEmail(JwtToken token);

}
