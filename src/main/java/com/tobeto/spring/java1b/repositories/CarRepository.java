package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
  @Query("select new com.tobeto.spring.java1b.services.dtos.responses.car.GetCarListResponse"+
          "(c.modelName,c.price,c.fuelType,new com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse(b.name)) from Car c inner join c.brand b")
   List<GetCarListResponse> getAll2();
}
