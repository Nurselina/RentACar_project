package com.tobeto.spring.java1b.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand") // attribute ismi
    private List<Car> cars;
}
