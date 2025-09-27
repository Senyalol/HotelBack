package com.HotelBack.Hotel.Security;

import com.HotelBack.Hotel.Security.SDTO.*;
import com.HotelBack.Hotel.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5174"})
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final UserServiceImpl userServiceImpl;
    private final JWTService jwtService;

    @Autowired
    public AuthController(UserServiceImpl userServiceImpl, JWTService jwtService) {
        this.userServiceImpl = userServiceImpl;
        this.jwtService = jwtService;
    }

    //Метод отвечающий за аутентификацию
    //Адрес http://localhost:8080/auth/sign-in
    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationDTO> SignIn(@RequestBody UserCredentialDTO userCredentialDTO) {

        try {
            return ResponseEntity.ok(userServiceImpl.signIn(userCredentialDTO));
        }
        catch(Exception e){
            throw new RuntimeException("Authentication failed" + e.getCause());
        }

    }

    //Метод отвечающий за Обновление токена
    //Адрес http://localhost:8080/auth/refresh
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationDTO> RefreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO) {
        try{
            return ResponseEntity.ok(userServiceImpl.refreshToken(refreshTokenDTO));
        }
        catch(Exception e){
            throw new RuntimeException("Refresh token - failed" + e.getCause());
        }

    }

    //Метод отвечающий за получение Email по токену
    //Адрес http://localhost:8080/auth/getEmail
    @PostMapping("/getEmail")
    public ResponseEntity<EmailFromTokenDTO> GetEmailFromToke(@RequestBody JwtTokenDTO jwtTokenDTO) {
        try{
            return ResponseEntity.ok(jwtService.parseTokenForEmail(jwtTokenDTO));
        }
        catch(Exception e){
            throw new RuntimeException("Get email from token - failed" + e.getCause());
        }
    }

}
