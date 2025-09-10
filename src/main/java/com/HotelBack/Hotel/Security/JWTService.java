package com.HotelBack.Hotel.Security;

//import org.springframework.context.annotation.Configuration;

import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Repository.UserRoleRepository;
import com.HotelBack.Hotel.Security.SDTO.EmailFromTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

//@Configuration
@Service
public class JWTService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
//    private final UserMapper userMapper;

    private final String signatureKey = "yQPE6xublU1wnS8demYaZVEqqaV3IHky4w3G3jdxQ3dR61EWLuTgJHzRRrG2TZUOpnXjFPMypB279oSHbFNEqw";

    @Autowired
    public JWTService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
//        this.userMapper = userMapper;
    }

    //Получить подпись ключа
    private SecretKey getSignInKey(){
        try {
            byte[] keyBytes = Decoders.BASE64.decode(signatureKey);
            System.out.println("Key bytes length: " + keyBytes.length);
            return Keys.hmacShaKeyFor(keyBytes);
        } catch (Exception e) {
            throw new RuntimeException("Invalid secret key", e);
        }
    }

    //Получить роль пользователя
    private String getRoleUser(String email){

        User certainUser = userRepository.findByEmail(email);

        return userRoleRepository.findByUserId(certainUser.getId()).getRole();
    }

    //Валидация токена , проверка на ориг
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
            return true;
        }

        catch (ExpiredJwtException e){
            System.out.println(e.getMessage());
            return false;
        }
        catch (UnsupportedJwtException e){
            System.out.println(e.getMessage());
            return false;
        }
        catch (MalformedJwtException e){
            System.out.println(e.getMessage());
            return false;
        }
        catch (SecurityException e){
            System.out.println(e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Метод для генерации JWT токена
    public String generateJwtToken(String email, String role) {

        Date lifeTimeToken = Date.from(LocalDateTime.now().plusHours(11).atZone(ZoneId.systemDefault()).toInstant());

        return  Jwts.builder()
                .setSubject(email)
                .claim("role",role)
                .setExpiration(lifeTimeToken)
                .signWith(getSignInKey())
                .compact();

    }

    //Метод при прохождении аутентификации которого - пользователь получает токен
    public JwtAuthenticationDTO getTokenForUser(String email){

        String role = getRoleUser(email);
        JwtAuthenticationDTO jwtDTO = new JwtAuthenticationDTO();
        jwtDTO.setToken(generateJwtToken(email, role));
        jwtDTO.setRefreshToken(generateJwtToken(email, role));

        return jwtDTO;

    }

    //Генерация рефреш токена
    public JwtAuthenticationDTO generateRefreshToken(String email, String refreshToken){

        JwtAuthenticationDTO jwtDTO = new JwtAuthenticationDTO();
        String role = getRoleUser(email);
        jwtDTO.setToken(generateJwtToken(email, role));
        jwtDTO.setRefreshToken(refreshToken);


        return jwtDTO;
    }

    //Получить email по токену
    public String getEmailFromToken(String token){
        Claims email = Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
        return email.getSubject();
    }

    public EmailFromTokenDTO parseTokenForEmail(JwtTokenDTO token){

        Claims email = Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token.getToken()).getPayload();

        EmailFromTokenDTO emailDTO = new EmailFromTokenDTO();
        emailDTO.setEmail(email.getSubject());
        return emailDTO;
    }

}
