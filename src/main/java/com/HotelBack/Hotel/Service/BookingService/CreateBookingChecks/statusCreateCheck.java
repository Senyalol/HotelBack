package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;

public class statusCreateCheck implements CreateBookingCheck{
    @Override
    public boolean check(Booking booking) {


        if(booking.getStatus() == null){
            //Нужно протестировать
            booking.setStatus(BookingStatus.активно.toString());
            return true;
        }
        else if(booking.getStatus().equals(BookingStatus.активно.toString())){
            return true;
        }
        else if(booking.getStatus().equals(BookingStatus.отменено.toString())){
            return true;
        }

        return false;
    }
}
