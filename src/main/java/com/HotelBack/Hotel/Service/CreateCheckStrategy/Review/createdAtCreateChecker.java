package com.HotelBack.Hotel.Service.CreateCheckStrategy.Review;

import com.HotelBack.Hotel.DTO.ReviewDTO;

import java.time.Instant;

public class createdAtCreateChecker implements CreateReviewCheck{
    @Override
    public boolean check(ReviewDTO reviewDTO) {

        boolean result = true;

        if(reviewDTO == null){

            result = false;

        }
        else if(reviewDTO.getCreated_at() == null){
            Instant cuurentTime = Instant.now();
            reviewDTO.setCreated_at(cuurentTime);
            result = true;
        }

        return result;
    }
}
