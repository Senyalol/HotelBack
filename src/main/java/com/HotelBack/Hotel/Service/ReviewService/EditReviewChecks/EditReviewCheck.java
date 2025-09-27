package com.HotelBack.Hotel.Service.ReviewService.EditReviewChecks;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Entity.Review;

public interface EditReviewCheck {

    void check(ReviewDTO reviewDTO, Review review);

}
