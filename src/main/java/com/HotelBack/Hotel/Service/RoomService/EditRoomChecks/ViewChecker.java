package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class ViewChecker implements EditRoomCheck {

    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null) {

            if(updateRoom.getView() != null){
                room.setView(updateRoom.getView());
            }

        }

    }
}
