package com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class capacityCreateChecker implements  CreateRoomCheck{
    @Override
    public boolean check(Room room) {
        boolean result = true;

        if(room == null || room.getCapacity() == null){
            result = false;
        }

        return result;
    }
}
