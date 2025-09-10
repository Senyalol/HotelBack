package com.HotelBack.Hotel.Service.CreateCheckStrategy.RoomImage;

import com.HotelBack.Hotel.DTO.RoomImageDTO;

public class imageCreateChecker implements CreateRoomImageCheck{
    @Override
    public boolean check(RoomImageDTO roomImageDTO) {

        boolean result = true;

        if(roomImageDTO == null || roomImageDTO.getImageUrl() == null){
            result = false;
        }

        return result;
    }
}
