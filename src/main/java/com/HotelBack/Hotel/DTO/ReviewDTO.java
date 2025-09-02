package com.HotelBack.Hotel.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class ReviewDTO {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("stay_duration")
    private String StayDuration;

    @JsonProperty("advantages")
    private String advantages;

    @JsonProperty("disadvantages")
    private String disadvantages;

    @JsonProperty("rating")
    private Short rating;

    @JsonProperty("created_at")
    private Instant created_at;

}
