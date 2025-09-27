package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.DTO.BookingDTO;
import lombok.Data;

import java.util.List;

@Data
public class BookingCreateChecker {

    private final List<CreateBookingCheck> checks;

    public BookingCreateChecker(List<CreateBookingCheck> checks) {
        this.checks = checks;
    }

    public boolean check(BookingDTO bookingDTO) {

        boolean result = true;

        for(CreateBookingCheck check : checks) {

            if(!check.check(bookingDTO)) {
                result = false;
            }

        }
        return result;
    }

}
