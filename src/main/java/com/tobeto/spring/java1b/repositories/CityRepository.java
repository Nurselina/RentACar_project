package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
