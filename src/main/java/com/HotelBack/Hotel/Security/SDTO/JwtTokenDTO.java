package com.HotelBack.Hotel.Security.SDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JwtTokenDTO {

    @JsonProperty("token")
    private String token;

}
