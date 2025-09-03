package com.HotelBack.Hotel.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

//@Getter
//@Setter
@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_id_gen")
    @SequenceGenerator(name = "bookings_id_gen", sequenceName = "bookings_booking_id_seq", allocationSize = 1)
    @Column(name = "booking_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Size(max = 20)
    @ColumnDefault("'активно'")
    @Column(name = "status", length = 20)
    private String status;

}