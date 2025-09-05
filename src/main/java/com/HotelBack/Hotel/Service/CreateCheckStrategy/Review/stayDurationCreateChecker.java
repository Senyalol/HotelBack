package com.HotelBack.Hotel.Service.CreateCheckStrategy.Review;

import com.HotelBack.Hotel.DTO.ReviewDTO;

public class stayDurationCreateChecker implements CreateReviewCheck{
    @Override
    public boolean check(ReviewDTO reviewDTO) {
        boolean result = true;

        if(reviewDTO == null || reviewDTO.getStayDuration() == null){
            result = false;
        }

        return result;
    }
}
