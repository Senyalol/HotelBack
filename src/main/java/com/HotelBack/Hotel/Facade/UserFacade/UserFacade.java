package com.HotelBack.Hotel.Facade.UserFacade;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.RefreshTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.UserCredentialDTO;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.util.List;

@Component
public interface UserFacade {

    UserDTO findUser(int id);

    void deleteYourUser(JwtTokenDTO jwtDTO);

    UserDTO getYourself(JwtTokenDTO jwtDTO);

    UserDTO updateYourSelf(String authHeader,UserDTO userDTO);

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    void deleteUser(int userId);

    UserDTO updateUser(int id,UserDTO userDTO);

    JwtAuthenticationDTO signIn(UserCredentialDTO userCredentialDTO);

    JwtAuthenticationDTO refreshToken(RefreshTokenDTO refreshTokenDTO) throws AuthenticationException;

}