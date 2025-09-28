package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Repository.UserRepository;

public class userIdCreateChecker implements CreateBookingCheck{

    private final UserRepository userRepository;

    public userIdCreateChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean check(Booking booking) {

        boolean result = true;

         if(booking == null || booking.getUser().getId() == null
                 || userRepository.findById(booking.getUser().getId()).isEmpty()){

            result = false;
        }

        return result;
    }
}
