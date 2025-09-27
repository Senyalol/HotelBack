package com.HotelBack.Hotel.Security;

import com.HotelBack.Hotel.Entity.SecurityEntity.EmailFromToken;
import com.HotelBack.Hotel.Entity.SecurityEntity.JwtAuthentication;
import com.HotelBack.Hotel.Entity.SecurityEntity.JwtToken;
import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Repository.UserRoleRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JWTServiceImpl implements JWTService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Value("${app.signature_key}")
    private String signatureKey;

    @Autowired
    public JWTServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    //Получить подпись ключа
    private SecretKey getSignInKey(){
        try {
            byte[] keyBytes = Decoders.BASE64.decode(signatureKey);
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
    public JwtAuthentication getTokenForUser(String email){

        String role = getRoleUser(email);
        JwtAuthentication jwt = new JwtAuthentication();
        jwt.setToken(generateJwtToken(email, role));
        jwt.setRefreshToken(generateJwtToken(email, role));

        return jwt;

    }

    //Генерация рефреш токена
    public JwtAuthentication generateRefreshToken(String email, String refreshToken){

        JwtAuthentication jwt = new JwtAuthentication();
        String role = getRoleUser(email);
        jwt.setToken(generateJwtToken(email, role));
        jwt.setRefreshToken(refreshToken);

        return jwt;
    }

    //Получить email по токену
    public String getEmailFromToken(String token){
        Claims email = Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
        return email.getSubject();
    }

    public EmailFromToken parseTokenForEmail(JwtToken token){

        Claims email = Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token.getToken()).getPayload();

        EmailFromToken emailE = new EmailFromToken();
        emailE.setEmail(email.getSubject());
        return emailE;
    }

}
