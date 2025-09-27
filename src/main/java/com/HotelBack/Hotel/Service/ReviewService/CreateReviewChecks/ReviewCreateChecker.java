package com.HotelBack.Hotel.Service.ReviewService.CreateReviewChecks;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import lombok.Data;

import java.util.List;

@Data
public class ReviewCreateChecker {

    private List<CreateReviewCheck> checks;

    public ReviewCreateChecker(List<CreateReviewCheck> checks) {
        this.checks = checks;
    }

    public boolean check(ReviewDTO reviewDTO){

        boolean result = true;

        for(CreateReviewCheck check : checks){

            if(!check.check(reviewDTO)){
                result = false;
            }

        }
        return result;
    }

}
