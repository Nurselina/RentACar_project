package com.tobeto.spring.java1b.entities;

import jakarta.persistence.*;
//test

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="postal_code")
    private String postalCode;
    @Column(name="address_text")
    private String addressText;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name="county_id")
    private County county;
}
