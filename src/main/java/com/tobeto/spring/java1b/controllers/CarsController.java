package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.java1b.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.java1b.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.java1b.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    @GetMapping
    public List<GetCarListResponse> getAll(){
        List<Car> carList=carRepository.findAll();
        List<GetCarListResponse> getCarListResponses =new ArrayList<>();
        for (Car car: carList){
            GetCarListResponse response =new GetCarListResponse();
            response.setModelName(car.getModelName());
            response.setFuelType(car.getFuelType());
            response.setPrice(car.getPrice());
            getCarListResponses.add(response);
        }
        return getCarListResponses;
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse getCarResponse=new GetCarResponse();
        getCarResponse.setModelYear(car.getModelYear());
        getCarResponse.setModelName(car.getModelName());
        getCarResponse.setPrice(car.getPrice());

        return getCarResponse;


    }
    @PostMapping
    public void add(@RequestBody AddCarRequest carAdd){
        Car car =new Car();
        car.setModelYear(carAdd.getModelYear());
        car.setModelName(carAdd.getModelName());
        carRepository.save(car);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest carUpdate) throws Exception {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setModelName(carUpdate.getModelName());
            car.setFuelType(carUpdate.getFuelType());
            car.setPrice(carUpdate.getPrice());
            carRepository.save(car);
        } else {
             throw new Exception("Güncellenemedi.");
        }

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);

    }
  }
