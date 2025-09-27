package com.HotelBack.Hotel.Service.ReviewService;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Entity.Review;
import com.HotelBack.Hotel.Mapping.ReviewMapper;
import com.HotelBack.Hotel.Repository.ReviewRepository;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Service.ReviewService.CreateReviewChecks.*;
import com.HotelBack.Hotel.Service.ReviewService.EditReviewChecks.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@JsonSerialize
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.userRepository = userRepository;
    }

    //Получить список всех отзывов
    public List<ReviewDTO> getAllReviews() {

        List<Review> reviews = reviewRepository.findAll();

        return reviews.stream()
                .map(review -> reviewMapper.reviewToReviewDTO(review))
                .collect(Collectors.toList());

    }

    //Удалить отзыв по его id
    public void deleteReview(int id){
        reviewRepository.deleteById(id);
    }

    //Добавить отзыв
    public ReviewDTO createReview(ReviewDTO reviewDTO) {

        if(reviewDTO != null){

            try{

                List<CreateReviewCheck> checks = Arrays.asList(
                  new userIdCreateChecker(userRepository),
                  new stayDurationCreateChecker(),
                  new advantagesCreateChecker(),
                  new disadvantagesCreateChecker(),
                  new ratingCreateChecker(),
                  new createdAtCreateChecker()
                );

                ReviewCreateChecker checker = new ReviewCreateChecker(checks);

                if(checker.check(reviewDTO)){

                    reviewRepository.save(reviewMapper.reviewDTOToReview(reviewDTO));
                    return reviewDTO;
                }

            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }
        return null;
    }

    //Редактировать отзыв
    public ReviewDTO updateReview(int id,ReviewDTO reviewDTO) {

        Review editableReview = reviewRepository.findById(id);

        if(reviewDTO != null){

            try{

                List<EditReviewCheck> checks = Arrays.asList(
                  new userIdChecker(userRepository),
                  new stayDurationChecker(),
                  new advantagesChecker(),
                  new disadvantagesChecker(),
                  new ratingChecker(),
                  new createdAtChecker()
                );

                ReviewChecker checker = new ReviewChecker(checks);

                checker.check(reviewDTO, editableReview);

            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

        return reviewMapper.reviewToReviewDTO(reviewRepository.findById(id));

    }

}
