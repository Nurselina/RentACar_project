package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.repositories.CarRepository;
import com.tobeto.spring.java1b.services.abstracts.CarService;
import com.tobeto.spring.java1b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.java1b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<GetCarListResponse> getAll() {
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

    @Override
    public List<GetCarListResponse> getAll2() {

        return carRepository.getAll2();
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse getCarResponse=new GetCarResponse();
        getCarResponse.setModelYear(car.getModelYear());
        getCarResponse.setModelName(car.getModelName());
        getCarResponse.setPrice(car.getPrice());

        return getCarResponse;

    }

    @Override
    public void add(AddCarRequest carAdd) {
        Car car =new Car();
        car.setModelYear(carAdd.getModelYear());
        car.setModelName(carAdd.getModelName());
        carRepository.save(car);
    }

    @Override
    public void update(int id, UpdateCarRequest carUpdate) throws Exception {
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

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}
