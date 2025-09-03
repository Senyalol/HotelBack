package com.HotelBack.Hotel.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDTO {

    @JsonProperty("room_id")
    private Integer roomId;

    @JsonProperty("room_name")
    private String roomName;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("bed_type")
    private String bedType;

    @JsonProperty("area")
    private BigDecimal area;

    @JsonProperty("capacity")
    private Integer capacity;

    @JsonProperty("view")
    private String view;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;

}
