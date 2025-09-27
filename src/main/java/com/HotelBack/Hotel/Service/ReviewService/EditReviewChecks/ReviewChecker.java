package com.HotelBack.Hotel.Service.ReviewService.EditReviewChecks;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class ReviewChecker {

    private List<EditReviewCheck> checks;

    public ReviewChecker(List<EditReviewCheck> checks) {
        this.checks = checks;
    }

    public void check(ReviewDTO reviewDTO, Review review) {

        for (EditReviewCheck check : checks) {

            check.check(reviewDTO, review);

        }

    }

}
