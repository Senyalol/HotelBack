package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class BedTypeChecker implements EditRoomCheck {


    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null){

            if(updateRoom.getBedType() != null){
                room.setBedType(updateRoom.getBedType());
            }

        }

    }
}
