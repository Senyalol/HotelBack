package com.HotelBack.Hotel.Service.EditCheckStrategy.Room;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public interface EditRoomCheck {

    void check(RoomDTO roomDTO, Room room);

}
