package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class AreaChecker implements EditRoomCheck {

    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null){

            if(updateRoom.getArea() != null){
                room.setArea(updateRoom.getArea());
            }

        }

    }

}
