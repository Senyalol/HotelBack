package com.HotelBack.Hotel.Service.CreateCheckStrategy.Booking;

import com.HotelBack.Hotel.DTO.BookingDTO;

public class statusCreateCheck implements CreateBookingCheck{
    @Override
    public boolean check(BookingDTO bookingDTO) {


        if(bookingDTO.getStatus() == null){
            //Нужно протестировать
            bookingDTO.setStatus(BookingStatus.активно.toString());
            return true;
        }
        else if(bookingDTO.getStatus().equals(BookingStatus.активно.toString())){
            return true;
        }
        else if(bookingDTO.getStatus().equals(BookingStatus.отменено.toString())){
            return true;
        }

        return false;
    }
}
