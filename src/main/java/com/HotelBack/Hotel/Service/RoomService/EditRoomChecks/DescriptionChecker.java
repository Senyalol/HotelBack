package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class DescriptionChecker implements EditRoomCheck {
    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null){

            if(updateRoom.getDescription() != null){
                room.setDescription(updateRoom.getDescription());
            }

        }

    }
}
