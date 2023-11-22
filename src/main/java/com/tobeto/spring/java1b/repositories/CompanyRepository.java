package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
