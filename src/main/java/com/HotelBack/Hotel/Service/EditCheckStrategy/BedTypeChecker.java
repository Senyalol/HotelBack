package com.HotelBack.Hotel.Service.EditCheckStrategy;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class BedTypeChecker implements EditCheck {


    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null){

            if(roomDTO.getBedType() != null){
                room.setBedType(roomDTO.getBedType());
            }

        }

    }
}
