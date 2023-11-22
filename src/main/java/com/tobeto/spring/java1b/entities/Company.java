package com.tobeto.spring.java1b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private  String address;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="contact_phone")
    private int contactPhone;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Booking>bookings;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Order> orders;
}
