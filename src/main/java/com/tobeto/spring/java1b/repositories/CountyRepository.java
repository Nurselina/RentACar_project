package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.County;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountyRepository extends JpaRepository<County, Integer> {
}
