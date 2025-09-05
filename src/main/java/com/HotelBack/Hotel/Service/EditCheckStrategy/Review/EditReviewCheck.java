package com.HotelBack.Hotel.Service.EditCheckStrategy.Review;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Entity.Review;

public interface EditReviewCheck {

    void check(ReviewDTO reviewDTO, Review review);

}
