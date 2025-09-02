package com.HotelBack.Hotel.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {

    @JsonProperty("first_name")
    private String firstname;

    @JsonProperty("last_name")
    private String lastname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

}
