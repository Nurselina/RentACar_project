package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
