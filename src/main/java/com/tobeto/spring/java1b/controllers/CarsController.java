package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.services.abstracts.CarService;
import com.tobeto.spring.java1b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.java1b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;



    @GetMapping
    public List<GetCarListResponse> getAll(){
       return carService.getAll();
    }

    @GetMapping("getAll")
    public List<GetCarListResponse> getAll2(){
        return carService.getAll2();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
       return carService.getById(id);

    }
    @PostMapping
    public void add(@RequestBody AddCarRequest carAdd){
       carService.add(carAdd);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest carUpdate) throws Exception {
       carService.update(id,carUpdate);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);

    }
  }
