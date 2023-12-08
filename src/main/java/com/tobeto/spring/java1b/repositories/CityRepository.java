package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByNameIsContaining(String name);
    List<City> findByName(String name);
}
