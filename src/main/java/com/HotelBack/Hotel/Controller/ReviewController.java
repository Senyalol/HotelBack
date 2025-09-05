package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.ReviewDTO;
import com.HotelBack.Hotel.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //Получить список всех отзывов
    //Адрес http://localhost:8080/api/reviews
    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    //Оставить отзыв
    //Адрес http://localhost:8080/api/reviews
    @PostMapping
    public ReviewDTO addReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.createReview(reviewDTO);
    }

    //Удалить отзыв по id
    //Адрес http://localhost:8080/api/reviews/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }

    //Редактировать отзыв по id
    //Адрес http://localhost:8080/api/reviews/update/{id}
    @PatchMapping("/update/{id}")
    public ReviewDTO getReviewById(@PathVariable int id,@RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReview(id, reviewDTO);
    }

}
