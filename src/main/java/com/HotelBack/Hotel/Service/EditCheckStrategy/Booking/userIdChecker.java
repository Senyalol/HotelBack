package com.HotelBack.Hotel.Service.EditCheckStrategy.Booking;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Repository.UserRepository;


public class userIdChecker implements EditBookingCheck{

    private final UserRepository userRepository;

    public userIdChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void check(BookingDTO bookingDTO, Booking booking) {

        if(bookingDTO != null && bookingDTO.getUserId() != null){
            int userId = bookingDTO.getUserId();

            booking.setUser(userRepository.findById(userId));


        }

    }
}
