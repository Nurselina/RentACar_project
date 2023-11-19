package com.tobeto.spring.java1b.entities;

import jakarta.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="model_year")
    private int modelYear;
    @Column(name="model_name")
    private String modelName;
    @Column(name="color")
    private  String color;
    @Column(name="fuel_type")
    private String fuelType;
    @Column(name="gear_type")
    private String gearType;
    @Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;




}
