package com.tobeto.spring.java1b.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="tckn")
    private int tckn;
    @Column(name="driving_licanse_no")
    private int drivingLicanseNo;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="phone")
    private int phone;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "customer") // attribute ismi
    private List<Order> rentalDetails;

    @OneToMany(mappedBy = "customer")
    private List<Address>addresses;

    @OneToMany(mappedBy = "customer")
    private List<Booking>bookings;
}
