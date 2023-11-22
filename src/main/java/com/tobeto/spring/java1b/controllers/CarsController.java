package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }
    @PutMapping("{id}")
    public void update(@RequestBody Car car){
        carRepository.findById(car.getId()).orElseThrow();
        carRepository.save(car);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);

    }
  }
