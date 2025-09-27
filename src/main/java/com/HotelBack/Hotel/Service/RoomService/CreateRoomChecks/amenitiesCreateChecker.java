package com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class amenitiesCreateChecker implements CreateRoomCheck{

    @Override
    public boolean check(Room room) {

        boolean result = true;

        if(room == null || room.getAmenities() == null){
            result = false;
        }

        return result;
    }
}
