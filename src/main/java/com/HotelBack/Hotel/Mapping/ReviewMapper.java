package com.HotelBack.Hotel.Mapping;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Entity.Review;
import com.HotelBack.Hotel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    private final UserRepository userRepository;

    @Autowired
    public ReviewMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Из сущности в DTO
    public ReviewDTO reviewToReviewDTO(Review review) {

        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setReviewId(review.getId());
        reviewDTO.setUserId(review.getUser().getId());
        reviewDTO.setStayDuration(review.getStayDuration());
        reviewDTO.setAdvantages(review.getAdvantages());
        reviewDTO.setDisadvantages(review.getDisadvantages());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setCreated_at(review.getCreatedAt());

        return reviewDTO;
    }

    //Из DTO в сущность
    public Review reviewDTOToReview(ReviewDTO reviewDTO) {

        Review review = new Review();

        review.setId(reviewDTO.getReviewId());
        review.setUser(userRepository.findById(reviewDTO.getUserId()).get());
        review.setStayDuration(reviewDTO.getStayDuration());
        review.setAdvantages(reviewDTO.getAdvantages());
        review.setDisadvantages(reviewDTO.getDisadvantages());
        review.setRating(reviewDTO.getRating());
        review.setCreatedAt(reviewDTO.getCreated_at());

        return review;
    }

}
