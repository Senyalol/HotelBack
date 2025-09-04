package com.HotelBack.Hotel.Service.CreateCheckStrategy.Room;

import com.HotelBack.Hotel.DTO.RoomDTO;

public class roomNameCreateChecker implements CreateRoomCheck{
    @Override
    public boolean check(RoomDTO room) {
        boolean result = true;

        if(room == null || room.getRoomName() == null){
            result = false;
        }

        return result;
    }
}
