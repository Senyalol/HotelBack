package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class PriceChecker implements EditRoomCheck {

    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null){
            if(roomDTO.getPrice() != null){
                room.setPrice(roomDTO.getPrice());
            }

        }

    }

}
