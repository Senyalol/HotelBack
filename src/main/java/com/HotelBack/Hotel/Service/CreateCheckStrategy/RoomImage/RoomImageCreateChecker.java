package com.HotelBack.Hotel.Service.CreateCheckStrategy.RoomImage;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoomImageCreateChecker {

    private final List<CreateRoomImageCheck> checks;

    public RoomImageCreateChecker(List<CreateRoomImageCheck> checks) {
        this.checks = checks;
    }

    public boolean check(RoomImageDTO roomImageDTO) {

        boolean result = true;

        for(CreateRoomImageCheck check : checks) {

            if(!check.check(roomImageDTO)) {
                result = false;
            }

        }

        return result;
    }

}
