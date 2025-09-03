package com.HotelBack.Hotel.Service.EditCheckStrategy;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class ViewChecker implements EditCheck {

    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null) {

            if(roomDTO.getView() != null){
                room.setView(roomDTO.getView());
            }

        }

    }
}
