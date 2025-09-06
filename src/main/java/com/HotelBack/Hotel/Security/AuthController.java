package com.HotelBack.Hotel.Security;

import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.RefreshTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.UserCredentialDTO;
import com.HotelBack.Hotel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    //Метод отвечающий за аутентификацию
    //Адрес http://localhost:8080/auth/sign-in
    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationDTO> SignIn(@RequestBody UserCredentialDTO userCredentialDTO) {

        try {
            return ResponseEntity.ok(userService.signIn(userCredentialDTO));
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
            return ResponseEntity.ok(userService.refreshToken(refreshTokenDTO));
        }
        catch(Exception e){
            throw new RuntimeException("Refresh token - failed" + e.getCause());
        }

    }

}
