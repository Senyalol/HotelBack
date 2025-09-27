package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class CapacityChecker implements EditRoomCheck {

    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null){

            if(updateRoom.getCapacity() != null){
                room.setCapacity(updateRoom.getCapacity());
            }

        }

    }

}
