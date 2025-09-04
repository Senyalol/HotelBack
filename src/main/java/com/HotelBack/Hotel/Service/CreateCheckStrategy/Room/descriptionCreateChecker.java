package com.HotelBack.Hotel.Service.CreateCheckStrategy.Room;

import com.HotelBack.Hotel.DTO.RoomDTO;

public class descriptionCreateChecker implements CreateRoomCheck{
    @Override
    public boolean check(RoomDTO room) {

        boolean result = true;
        if(room == null || room.getDescription() == null){

            result = false;

        }

        return result;
    }
}
