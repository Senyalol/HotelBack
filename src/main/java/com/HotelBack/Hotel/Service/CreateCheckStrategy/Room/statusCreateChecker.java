package com.HotelBack.Hotel.Service.CreateCheckStrategy.Room;

import com.HotelBack.Hotel.DTO.RoomDTO;

public class statusCreateChecker implements CreateRoomCheck{

    @Override
    public boolean check(RoomDTO room) {

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
            return true;
        }

        return false;
    }
}
