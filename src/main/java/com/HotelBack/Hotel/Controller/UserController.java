package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Security.SDTO.JwtTokenDTO;
import com.HotelBack.Hotel.Service.UserService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5174"})
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    //Создать пользователя
    //Адрес - http://localhost:8080/api/users
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userServiceImpl.createUser(userDTO);
    }

    //Посмотреть всех пользователей
    //Адрес - http://localhost:8080/api/users
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    //Найти пользователя по id
    //Адрес - http://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return userServiceImpl.findUser(id);
    }

    //Редактировать пользователя
    //Адрес - http://localhost:8080/api/users/update/id
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userServiceImpl.updateUser(id, userDTO);
    }

    //@PreAuthorize("hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_USER')")

    //Удалить пользователя
    //Адрес - http://localhost:8080/api/users/delete/id
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userServiceImpl.deleteUser(id);
    }

    //Удалить свой аккаунт
    //Адрес - http://localhost:8080/api/users/delete
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PostMapping("/delete")
    public void deleteYourself(@RequestBody JwtTokenDTO jwtTokenDTO) {
        userServiceImpl.deleteYourUser(jwtTokenDTO);
    }

    //Получить данные своего аккаунта
    //Адрес - http://localhost:8080/api/users/yours
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PostMapping("/yours")
    public UserDTO getYourself(@RequestBody JwtTokenDTO jwtTokenDTO) {
        return userServiceImpl.getYourself(jwtTokenDTO);
    }

    //Обновить собственного пользователя
    //Адрес - http//localhost:8080/api/users/update
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PatchMapping("/update")
    public UserDTO updateYourself(@RequestHeader("Authorization") String authHeader, @RequestBody UserDTO userDTO) {
        return userServiceImpl.updateYourSelf(authHeader,userDTO);
    }

}
