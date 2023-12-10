package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.City;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    //Derived Query Methods
    List<City> findByNameIsContaining(String name);
    List<City> findByName(String name);

    //JPQL Query Methods
    @Query("select new com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse(c.name) " +
            "from City c where c.name IS NOT NULL ")
    List<GetCityListResponse> findByNameIsNotNull();

    @Query("select new com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse(c.name)" +
            "from City c where LOWER(c.name) = LOWER(:name) ")
    List<GetCityListResponse> findByNameIgnoreCase (String name);



}
