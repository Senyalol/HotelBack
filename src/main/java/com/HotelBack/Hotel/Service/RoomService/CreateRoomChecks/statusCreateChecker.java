package com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class statusCreateChecker implements CreateRoomCheck{

    @Override
    public boolean check(Room room) {

        boolean result = true;
        if(room.getStatus().equals(RoomStatus.свободен.toString())){
            return true;
        }
        else if(room.getStatus().equals(RoomStatus.занят.toString())){
            return true;
        }
        else if(room.getStatus().equals(RoomStatus.забронирован.toString())){
            return true;
        }
        else if(room.getStatus() == null){
            room.setStatus(RoomStatus.свободен.toString());
            return true;
        }

        return false;
    }
}
