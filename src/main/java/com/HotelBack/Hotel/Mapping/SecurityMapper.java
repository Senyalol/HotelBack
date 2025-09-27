package com.HotelBack.Hotel.Mapping;

import com.HotelBack.Hotel.Entity.SecurityEntity.*;
import com.HotelBack.Hotel.Security.SDTO.*;
import org.springframework.stereotype.Component;

@Component
public class SecurityMapper {

    //JwTAuthentication
    //Из DTO в сущность

    public JwtAuthentication toJwtAuthentication(JwtAuthenticationDTO jwtAuthenticationDTO) {

        JwtAuthentication jwtAuthentication = new JwtAuthentication();

        jwtAuthentication.setToken(jwtAuthenticationDTO.getToken());
        jwtAuthentication.setRefreshToken(jwtAuthenticationDTO.getRefreshToken());

        return jwtAuthentication;
    }

    //Из сущности в DTO
    public JwtAuthenticationDTO toJwtAuthenticationDTO(JwtAuthentication jwtAuthentication) {

        JwtAuthenticationDTO jwtAuthenticationDTO = new JwtAuthenticationDTO();

        jwtAuthenticationDTO.setToken(jwtAuthentication.getToken());
        jwtAuthenticationDTO.setRefreshToken(jwtAuthentication.getRefreshToken());

        return jwtAuthenticationDTO;
    }

    //JWTToken
    //Из DTO в сущность

    public JwtToken toJwtToken(JwtTokenDTO jwtTokenDTO) {

        JwtToken jwtToken = new JwtToken();

        jwtToken.setToken(jwtTokenDTO.getToken());

        return jwtToken;
    }

    //Из сущности в DTO

    public JwtTokenDTO toJwtTokenDTO(JwtToken jwtToken) {

        JwtTokenDTO jwtTokenDTO = new JwtTokenDTO();

        jwtTokenDTO.setToken(jwtToken.getToken());

        return jwtTokenDTO;
    }

    //RefreshToken
    //Из DTO в сущность

    public RefreshToken toRefreshToken(RefreshTokenDTO refreshTokenDTO) {

        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setRefreshToken(refreshTokenDTO.getRefreshToken());

        return refreshToken;
    }

    public RefreshTokenDTO toRefreshTokenDTO(RefreshToken refreshToken) {

        RefreshTokenDTO refreshTokenDTO = new RefreshTokenDTO();

        refreshTokenDTO.setRefreshToken(refreshToken.getRefreshToken());

        return refreshTokenDTO;
    }

    //UserCredential
    //Из DTO в сущность

    public UserCredential toUserCredential(UserCredentialDTO userCredentialDTO) {

        UserCredential userCredential = new UserCredential();

        userCredential.setEmail(userCredentialDTO.getEmail());
        userCredential.setPassword(userCredentialDTO.getPassword());

        return userCredential;
    }

    //Из сущности в DTO
    public UserCredentialDTO toUserCredentialDTO(UserCredential userCredential) {

        UserCredentialDTO userCredentialDTO = new UserCredentialDTO();

        userCredentialDTO.setEmail(userCredential.getEmail());
        userCredentialDTO.setPassword(userCredential.getPassword());

        return userCredentialDTO;
    }

    //EmailFromToken
    //Из DTO в сущность

    public EmailFromToken toEmailFromToken(EmailFromTokenDTO emailFromTokenDTO){

        EmailFromToken emailFromToken = new EmailFromToken();

        emailFromToken.setEmail(emailFromTokenDTO.getEmail());

        return emailFromToken;
    }

    //Из сущности в DTO
    public EmailFromTokenDTO toEmailFromTokenDTO(EmailFromToken emailFromToken){

        EmailFromTokenDTO emailFromTokenDTO = new EmailFromTokenDTO();

        emailFromTokenDTO.setEmail(emailFromToken.getEmail());

        return emailFromTokenDTO;
    }

}
