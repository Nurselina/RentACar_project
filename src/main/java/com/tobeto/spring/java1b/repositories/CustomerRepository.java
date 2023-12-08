package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   List<Customer> findByEmailIsNull();
   List<Customer> findByFirstNameIgnoreCase (String name);
}
