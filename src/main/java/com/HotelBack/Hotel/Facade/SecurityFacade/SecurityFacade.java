package com.HotelBack.Hotel.Facade.SecurityFacade;

import com.HotelBack.Hotel.Security.SDTO.EmailFromTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;

public interface SecurityFacade {

    boolean validateJwtToken(String token);

    String generateJwtToken(String email, String role);

    JwtAuthenticationDTO getTokenForUser(String email);

    JwtAuthenticationDTO generateRefreshToken(String email, String refreshToken);

    String getEmailFromToken(String token);

    EmailFromTokenDTO parseTokenForEmail(JwtTokenDTO token);

}
