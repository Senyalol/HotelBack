package com.HotelBack.Hotel.Service.ReviewService.CreateReviewChecks;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Repository.UserRepository;

public class userIdCreateChecker implements CreateReviewCheck{

    private final UserRepository userRepository;

    public userIdCreateChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean check(ReviewDTO reviewDTO) {

        boolean result = true;

        if(reviewDTO == null || reviewDTO.getUserId() == null || userRepository.findById(reviewDTO.getUserId()).isEmpty()) {
            result = false;
        }

        return result;
    }
}
