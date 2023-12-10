package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.County;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountyRepository extends JpaRepository<County, Integer> {
    //Derived Query Methods
    List<County> findByNameEndingWith(String name);
    County findFirstByNameIsNotNull ();

    //JPQL Query Methods
   /* @Query("select new com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse" +
            "(c.name, new com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse(c.name)" +
            " from County c INNER JOIN c.city c Where c.name LIKE  %:name%")
    List<GetCountyListResponse> findByName1 (String name);*/

    //TODO: Burada jpql için query ekle


}
