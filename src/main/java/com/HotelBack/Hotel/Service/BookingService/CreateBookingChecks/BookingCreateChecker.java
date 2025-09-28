package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;
import lombok.Data;

import java.util.List;

@Data
public class BookingCreateChecker {

    private final List<CreateBookingCheck> checks;

    public BookingCreateChecker(List<CreateBookingCheck> checks) {
        this.checks = checks;
    }

    public boolean check(Booking booking) {

        boolean result = true;

        for(CreateBookingCheck check : checks) {

            if(!check.check(booking)) {
                result = false;
            }

        }
        return result;
    }

}
