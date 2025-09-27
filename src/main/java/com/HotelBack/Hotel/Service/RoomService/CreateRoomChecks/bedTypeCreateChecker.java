package com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks;

import com.HotelBack.Hotel.DTO.RoomDTO;

public class bedTypeCreateChecker implements CreateRoomCheck{
    @Override
    public boolean check(RoomDTO room) {
        boolean result = true;

        if(room == null || room.getBedType() == null){
            result = false;
        }

        return result;
    }
}
