package com.HotelBack.Hotel.Mapping;

import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {



    //Из сущности в DTO
    public UserDTO EntityToDTO(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getId());
        userDTO.setFirstname(user.getFirstName());
        userDTO.setLastname(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setAvatarUser(user.getAvatarUser());
        userDTO.setSecretKey(user.getSecretkey());

        return userDTO;
    }

    //Из DTO в сущность
    public User DTOToEntity(UserDTO userDTO) {

        User user = new User();

        user.setId(userDTO.getUserId());
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setAvatarUser(userDTO.getAvatarUser());
        user.setSecretkey(userDTO.getSecretKey());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return user;

    }

}
