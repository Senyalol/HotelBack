package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class StatusChecker implements EditRoomCheck {
    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null){

            if(updateRoom.getStatus() != null){
                room.setStatus(updateRoom.getStatus());
            }

        }

    }
}
