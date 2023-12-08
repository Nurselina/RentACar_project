package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.County;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountyRepository extends JpaRepository<County, Integer> {
    List<County> findByNameEndingWith(String name);
    County findFirstByNameIsNotNull ();
}
