package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;
import com.HotelBack.Hotel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5174"})
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Создать пользователя
    //Адрес - http://localhost:8080/api/users
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    //Посмотреть всех пользователей
    //Адрес - http://localhost:8080/api/users
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    //Редактировать пользователя
    //Адрес - http://localhost:8080/api/users/update/id
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    //@PreAuthorize("hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_USER')")

    //Удалить пользователя
    //Адрес - http://localhost:8080/api/users/delete/id
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    //Удалить свой аккаунт
    //Адрес - http://localhost:8080/api/users/delete
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PostMapping("/delete")
    public void deleteYourself(@RequestBody JwtTokenDTO jwtTokenDTO) {
        userService.deleteYourUser(jwtTokenDTO);
    }

    //Получить данные своего аккаунта
    //Адрес - http://localhost:8080/api/users/yours
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PostMapping("/yours")
    public UserDTO getYourself(@RequestBody JwtTokenDTO jwtTokenDTO) {
        return userService.getYourself(jwtTokenDTO);
    }

    //Обновить собственного пользователя
    //Адрес - http//localhost:8080/api/users/update
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PatchMapping("/update")
    public UserDTO updateYourself(@RequestHeader("Authorization") String authHeader, @RequestBody UserDTO userDTO) {
        return userService.updateYourSelf(authHeader,userDTO);
    }

}
