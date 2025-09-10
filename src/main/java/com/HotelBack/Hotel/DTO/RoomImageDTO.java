package com.HotelBack.Hotel.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoomImageDTO {

    @JsonProperty("room_image_id")
    private Integer roomImageId;

    @JsonProperty("room_id")
    private Integer roomId;

    @JsonProperty("image")
    private String imageUrl;

}
