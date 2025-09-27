package com.HotelBack.Hotel.Service.ReviewService.EditReviewChecks;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Entity.Review;

public class stayDurationChecker implements EditReviewCheck{
    @Override
    public void check(ReviewDTO reviewDTO, Review review) {

        if(reviewDTO != null && reviewDTO.getStayDuration() != null){

            review.setStayDuration(reviewDTO.getStayDuration());

        }

    }
}
