package com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks;

import com.HotelBack.Hotel.DTO.RoomDTO;

public class amenitiesCreateChecker implements CreateRoomCheck{
    @Override
    public boolean check(RoomDTO room) {

        boolean result = true;

        if(room == null || room.getAmenities() == null){
            result = false;
        }

        return result;
    }
}
