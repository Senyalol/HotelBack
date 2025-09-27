package com.HotelBack.Hotel.Facade.UserFacade;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Mapping.SecurityMapper;
import com.HotelBack.Hotel.Mapping.UserMapper;
import com.HotelBack.Hotel.Security.SDTO.JwtAuthenticationDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.RefreshTokenDTO;
import com.HotelBack.Hotel.Security.SDTO.UserCredentialDTO;
import com.HotelBack.Hotel.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;
    private final SecurityMapper securityMapper;

    @Autowired
    public UserFacadeImpl(UserService userService, UserMapper userMapper, SecurityMapper securityMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.securityMapper = securityMapper;
    }

    @Override
    public UserDTO findUser(int id) {
        return userMapper.EntityToDTO(userService.findUser(id));
    }

    @Override
    public void deleteYourUser(JwtTokenDTO jwtDTO) {
        userService.deleteYourUser(securityMapper.toJwtToken(jwtDTO));
    }

    @Override
    public UserDTO getYourself(JwtTokenDTO jwtDTO) {
        return userMapper.EntityToDTO(userService.getYourself(securityMapper.toJwtToken(jwtDTO)));
    }

    @Override
    public UserDTO updateYourSelf(String authHeader, UserDTO userDTO) {
        return userMapper.EntityToDTO(userService.updateYourSelf(authHeader,userMapper.DTOToEntity(userDTO)));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.EntityToDTO(userService.createUser(userMapper.DTOToEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(x-> userMapper.EntityToDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int userId) {
        userService.deleteUser(userId);
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userDTO) {
        return userMapper.EntityToDTO(userService.updateUser(id, userMapper.DTOToEntity(userDTO)));
    }

    @Override
    public JwtAuthenticationDTO signIn(UserCredentialDTO userCredentialDTO) {
        return securityMapper.toJwtAuthenticationDTO(userService.signIn(securityMapper.toUserCredential(userCredentialDTO)));
    }

    @Override
    public JwtAuthenticationDTO refreshToken(RefreshTokenDTO refreshTokenDTO) throws AuthenticationException {
        return securityMapper.toJwtAuthenticationDTO(userService.refreshToken(securityMapper.toRefreshToken(refreshTokenDTO)));
    }

}
