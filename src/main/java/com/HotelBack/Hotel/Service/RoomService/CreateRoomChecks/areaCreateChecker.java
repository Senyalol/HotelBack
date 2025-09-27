package com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks;

import com.HotelBack.Hotel.DTO.RoomDTO;

public class areaCreateChecker implements CreateRoomCheck{
    @Override
    public boolean check(RoomDTO room) {
        boolean result = true;

        if(room == null || room.getArea() == null){
            result = false;
        }

        return result;
    }
}
