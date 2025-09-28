package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Facade.BookingFacade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5174"})
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingFacade bookingFacade;

    @Autowired
    public BookingController(BookingFacade bookingFacade) {
       this.bookingFacade = bookingFacade;
    }

    //Получить список всех броней
    //Адрес http://localhost:8080/api/bookings
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping
    public List<BookingDTO> getAllBookings() {
        return bookingFacade.getAllBookings();
    }

    //Сделать бронь
    //Адрес http://localhost:8080/api/bookings
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PostMapping
    public BookingDTO addBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingFacade.createBooking(bookingDTO);
    }

    //Удалить бронь
    //Адрес http://localhost:8080/api/bookings/delete/{id}
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingFacade.deleteBooking(id);
    }

    //Редактировать бронь
    //Адрес http://localhost:8080/api/bookings/update/{id}
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/{id}")
    public BookingDTO updateBooking(@PathVariable int id, @RequestBody BookingDTO bookingDTO) {
        return bookingFacade.updateBooking(id, bookingDTO);
    }

}
