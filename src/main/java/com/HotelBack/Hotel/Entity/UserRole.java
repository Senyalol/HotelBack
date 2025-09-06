package com.HotelBack.Hotel.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Data
@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_roles_id_gen")
    @SequenceGenerator(name = "user_roles_id_gen", sequenceName = "user_roles_user_roles_id_seq", allocationSize = 1)
    @Column(name = "user_roles_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 30)
    @NotNull
    @Column(name = "role", nullable = false, length = 30)
    private String role;

}