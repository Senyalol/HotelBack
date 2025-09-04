package com.HotelBack.Hotel.Service.EditCheckStrategy.Booking;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;
import lombok.Data;

import java.util.List;

@Data
public class BookingChecker {

    private List<EditBookingCheck> checks;

    public BookingChecker(List<EditBookingCheck> checks) {
        this.checks = checks;
    }

    public void check(BookingDTO bookingDTO, Booking booking) {

        for (EditBookingCheck check : checks) {
            check.check(bookingDTO, booking);
        }

    }

}
