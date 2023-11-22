package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
