package com.tobeto.spring.java1b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private int id;
   @Column(name="amount")
   private double amount;
   @Column(name="date")
   private LocalDate date;
   @Column(name="start_rent")
   private  LocalDate startRent;
   @Column(name="end_rent")
   private  LocalDate endRent;

   @ManyToOne
   @JoinColumn(name="car_id")
   private Car car;

   @ManyToOne
   @JoinColumn(name="customer_id")
   private Customer customer;

   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company company;

}
