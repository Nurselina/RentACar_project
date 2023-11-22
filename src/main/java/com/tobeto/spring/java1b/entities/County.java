package com.tobeto.spring.java1b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="counties")
@Getter
@Setter
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "county")
    @JsonIgnore
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;




}
