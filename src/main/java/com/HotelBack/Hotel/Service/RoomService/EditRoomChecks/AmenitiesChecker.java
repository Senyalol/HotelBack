package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class AmenitiesChecker implements EditRoomCheck{

    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null  && updateRoom.getAmenities() != null) {

            room.setAmenities(updateRoom.getAmenities());

        }

    }

}
