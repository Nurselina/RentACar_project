package com.tobeto.spring.java1b.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
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

   @OneToMany(mappedBy = "order")
   private List<Car> cars;

   @ManyToOne
   @JoinColumn(name="customer_id")
   private Customer customer;

   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company company;



}
