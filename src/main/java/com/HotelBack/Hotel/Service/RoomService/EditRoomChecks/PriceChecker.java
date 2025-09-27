package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class PriceChecker implements EditRoomCheck {

    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null){
            if(updateRoom.getPrice() != null){
                room.setPrice(updateRoom.getPrice());
            }

        }

    }

}
