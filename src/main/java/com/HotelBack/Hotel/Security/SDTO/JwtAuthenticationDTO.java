package com.HotelBack.Hotel.Security.SDTO;

import lombok.Data;

@Data
public class JwtAuthenticationDTO {

    private String token;
    private String refreshToken;

}
