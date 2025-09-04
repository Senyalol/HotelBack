package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //Получить список всех броней
    //Адрес http://localhost:8080/api/bookings
    @GetMapping
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

    //Сделать бронь
    //Адрес http://localhost:8080/api/bookings
    @PostMapping
    public BookingDTO addBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }

    //Удалить бронь
    //Адрес http://localhost:8080/api/bookings/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }

    //Редактировать бронь
    //Адрес http://localhost:8080/api/bookings/update/{id}
    @PatchMapping("/update/{id}")
    public BookingDTO updateBooking(@PathVariable int id, @RequestBody BookingDTO bookingDTO) {
        return bookingService.updateBooking(id, bookingDTO);
    }

}
