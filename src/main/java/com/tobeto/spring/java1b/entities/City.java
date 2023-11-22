package com.tobeto.spring.java1b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="cities")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy ="city" )
    @JsonIgnore
    private List<Address> addresses;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<County> counties;
}

