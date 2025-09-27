package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Repository.UserRepository;

public class userIdCreateChecker implements CreateBookingCheck{

    private final UserRepository userRepository;

    public userIdCreateChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean check(BookingDTO bookingDTO) {

        boolean result = true;

         if(bookingDTO == null || bookingDTO.getUserId() == null || userRepository.findById(bookingDTO.getUserId()).isEmpty()){

            result = false;
        }

        return result;
    }
}
