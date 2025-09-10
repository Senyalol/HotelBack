package com.HotelBack.Hotel.Security.SDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmailFromTokenDTO {

    @JsonProperty("email")
    private String email;

}
