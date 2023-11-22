package com.tobeto.spring.java1b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="cars")
@Data // getter setter aynı anda ikisinide ekler
@AllArgsConstructor
@NoArgsConstructor
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

   // @ManyToOne
    //@JoinColumn(name="brand_id")
    //private Brand brand;


    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Booking> bookings;

    @OneToMany(mappedBy ="car" )
    @JsonIgnore
    private List<Order> orders;

    @ManyToOne(cascade = CascadeType.ALL) // Hibernate, cascade = CascadeType.ALL argümanı nedeniyle, Brand nesnesini de otomatik olarak kaydeder
    private Brand brand; // cascade = CascadeType.ALL argümanı, yalnızca ManyToOne ilişkileri için kullanılabilir.


}
