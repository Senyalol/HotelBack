package com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class viewCreateChecker implements CreateRoomCheck{
    @Override
    public boolean check(Room room) {
        boolean result = true;

        if(room == null || room.getView() == null){
            result = false;
        }

        return result;
    }
}
