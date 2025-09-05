package com.HotelBack.Hotel.Service.CreateCheckStrategy.Review;

import com.HotelBack.Hotel.DTO.ReviewDTO;

public class ratingCreateChecker implements CreateReviewCheck{
    @Override
    public boolean check(ReviewDTO reviewDTO) {

        boolean result = true;
        if(reviewDTO == null || reviewDTO.getRating() == null){

            result = false;

        }

        return result;
    }
}
