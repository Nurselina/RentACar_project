package com.tobeto.spring.java1b.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy ="city" )
    private List<Address> addresses;

    @OneToMany(mappedBy = "city")
    private List<County> counties;
}

