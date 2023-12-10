package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.services.dtos.requests.city.AddCityRequest;
import com.tobeto.spring.java1b.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CityService {
    List<GetCityListResponse> getAll();
    GetCityResponse getById(int id);
    void add(AddCityRequest addCityRequest);
    void update(int id, UpdateCityRequest updateCityRequest) throws Exception;
    void delete(int id);
    List<GetCityListResponse> findName(String name);
    List<GetCityListResponse> findByName (String name);
    List<GetCityListResponse> findByNameIsNotNull();
    List<GetCityListResponse> findByNameIgnoreCase(String name);
}
