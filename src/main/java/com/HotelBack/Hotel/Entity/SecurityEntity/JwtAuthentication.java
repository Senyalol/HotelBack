package com.HotelBack.Hotel.Entity.SecurityEntity;

import lombok.Data;

@Data
public class JwtAuthentication {

    private String token;

    private String refreshToken;

}

