package com.HotelBack.Hotel.Service.RoomImageService.EditRoomImageChecks;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Entity.RoomImage;

public interface EditRoomImageCheck {

    void check(RoomImageDTO roomImageDTO, RoomImage roomImage);

}
