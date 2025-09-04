package com.HotelBack.Hotel.Service.EditCheckStrategy.Room;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class AreaChecker implements EditRoomCheck {

    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null){

            if(roomDTO.getArea() != null){
                room.setArea(roomDTO.getArea());
            }

        }

    }

}
