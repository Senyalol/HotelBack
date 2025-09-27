package com.HotelBack.Hotel.Service.RoomImageService.EditRoomImageChecks;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Entity.RoomImage;
import lombok.Data;

import java.util.List;

@Data
public class RoomImageChecker {

    private final List<EditRoomImageCheck> checks;

    public RoomImageChecker(List<EditRoomImageCheck> checks) {
        this.checks = checks;
    }

    public void check(RoomImageDTO roomImageDTO, RoomImage roomImage) {

        for(EditRoomImageCheck check : checks) {

            check.check(roomImageDTO, roomImage);

        }

    }

}
