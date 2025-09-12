package com.HotelBack.Hotel.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

//@Getter
//@Setter
@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rooms_id_gen")
    @SequenceGenerator(name = "rooms_id_gen", sequenceName = "rooms_room_id_seq", allocationSize = 1)
    @Column(name = "room_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "room_name", nullable = false, length = 100)
    private String roomName;

    @NotNull
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Size(max = 50)
    @Column(name = "bed_type", length = 50)
    private String bedType;

    @Column(name = "area", precision = 5, scale = 2)
    private BigDecimal area;

    @Column(name = "capacity")
    private Integer capacity;

    @Size(max = 100)
    @Column(name = "view", length = 100)
    private String view;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Size(max = 20)
    @ColumnDefault("'свободен'")
    @Column(name = "status", length = 20)
    private String status;

    @Size(max = 1000)
    @Column(name = "amenities", length = 1000)
    private String amenities;

    @OneToMany(mappedBy = "room")
    private Set<Booking> bookings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "room")
    private Set<RoomImage> roomImages = new LinkedHashSet<>();

}