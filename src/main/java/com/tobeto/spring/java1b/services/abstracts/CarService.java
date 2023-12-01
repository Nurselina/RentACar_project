package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.java1b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarResponse;


import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest carAdd);
    void update(int id, UpdateCarRequest carUpdate) throws Exception;
    void delete(int id);
}
