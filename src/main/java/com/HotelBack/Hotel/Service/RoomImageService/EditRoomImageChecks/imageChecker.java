package com.HotelBack.Hotel.Service.RoomImageService.EditRoomImageChecks;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Entity.RoomImage;

public class imageChecker implements EditRoomImageCheck{
    @Override
    public void check(RoomImageDTO roomImageDTO, RoomImage roomImage) {

        if(roomImageDTO != null && roomImageDTO.getImageUrl() != null){

            roomImage.setImage(roomImageDTO.getImageUrl());

        }

    }
}
