package com.HotelBack.Hotel.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//@Getter
//@Setter
@Data
@Entity
@Table(name = "room_images")
public class RoomImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_images_id_gen")
    @SequenceGenerator(name = "room_images_id_gen", sequenceName = "room_images_room_image_id_seq", allocationSize = 1)
    @Column(name = "room_image_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "room_id")
    private Room room;

    @Size(max = 1000)
    @Column(name = "image", length = 1000)
    private String image;

}