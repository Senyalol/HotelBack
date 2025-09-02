package com.HotelBack.Hotel.Repository;

import com.HotelBack.Hotel.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public Review findById(int id);

}
