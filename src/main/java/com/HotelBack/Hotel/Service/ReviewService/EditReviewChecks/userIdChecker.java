package com.HotelBack.Hotel.Service.ReviewService.EditReviewChecks;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Entity.Review;
import com.HotelBack.Hotel.Repository.UserRepository;

public class userIdChecker implements EditReviewCheck{

    private final UserRepository userRepository;

    public userIdChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void check(ReviewDTO reviewDTO, Review review) {

        if(reviewDTO != null && reviewDTO.getUserId() != null){

            int userId = reviewDTO.getUserId();
            review.setUser(userRepository.findById(userId));

        }

    }
}
