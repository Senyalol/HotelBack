package com.HotelBack.Hotel.Service.BookingService.EditBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Repository.UserRepository;

public class userIdChecker implements EditBookingCheck{

    private final UserRepository userRepository;

    public userIdChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void check(Booking updateBooking, Booking booking) {

        if(updateBooking != null && updateBooking.getUser().getId() != null){
            int userId = updateBooking.getUser().getId();

            booking.setUser(userRepository.findById(userId));
            booking.setRoom(updateBooking.getRoom());

        }

    }

}
