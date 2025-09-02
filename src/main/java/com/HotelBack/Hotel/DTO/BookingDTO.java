package com.HotelBack.Hotel.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookingDTO {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("room_id")
    private Integer room_id;

    @JsonProperty("start_date")
    private String StartDate;

    @JsonProperty("end_date")
    private String EndDate;

    @JsonProperty("status")
    private String status;

}
