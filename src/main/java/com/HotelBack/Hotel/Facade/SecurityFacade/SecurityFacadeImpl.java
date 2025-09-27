package com.HotelBack.Hotel.Facade.SecurityFacade;

import com.HotelBack.Hotel.Mapping.SecurityMapper;
import com.HotelBack.Hotel.Security.JWTService;
import com.HotelBack.Hotel.Security.SDTO.EmailFromTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityFacadeImpl implements SecurityFacade {

    private final JWTService jwtService;
    private final SecurityMapper securityMapper;

    @Autowired
    public SecurityFacadeImpl(JWTService jwtService, SecurityMapper securityMapper) {
        this.jwtService = jwtService;
        this.securityMapper = securityMapper;
    }

    @Override
    public boolean validateJwtToken(String token) {
        return jwtService.validateJwtToken(token);
    }

    @Override
    public String generateJwtToken(String email, String role) {
        return jwtService.generateJwtToken(email, role);
    }

    @Override
    public JwtAuthenticationDTO getTokenForUser(String email) {
        return securityMapper.toJwtAuthenticationDTO(jwtService.getTokenForUser(email));
    }

    @Override
    public JwtAuthenticationDTO generateRefreshToken(String email, String refreshToken) {
        return securityMapper.toJwtAuthenticationDTO(jwtService.generateRefreshToken(email, refreshToken));
    }

    @Override
    public String getEmailFromToken(String token) {
        return jwtService.getEmailFromToken(token);
    }

    @Override
    public EmailFromTokenDTO parseTokenForEmail(JwtTokenDTO token) {
        return securityMapper.toEmailFromTokenDTO(jwtService.parseTokenForEmail(securityMapper.toJwtToken(token)));
    }
}
