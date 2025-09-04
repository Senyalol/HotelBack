package com.HotelBack.Hotel.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {

    @JsonProperty("booking_id")
    private Integer bookingId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("room_id")
    private Integer room_id;

    @JsonProperty("start_date")
    private LocalDate StartDate;

    @JsonProperty("end_date")
    private LocalDate EndDate;

    @JsonProperty("status")
    private String status;

}
