package com.HotelBack.Hotel.Mapping;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //Из сущности в DTO
    public UserDTO EntityToDTO(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setFirstname(user.getFirstName());
        userDTO.setLastname(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());


        return userDTO;
    }

    //Из DTO в сущность
    public User DTOToEntity(UserDTO userDTO) {

        User user = new User();

        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;

    }

}
