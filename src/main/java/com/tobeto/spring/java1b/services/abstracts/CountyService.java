package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.entities.County;
import com.tobeto.spring.java1b.services.dtos.requests.county.AddCountyRequest;
import com.tobeto.spring.java1b.services.dtos.requests.county.UpdateCountyRequest;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CountyService {
    List<GetCountyListResponse> getAll();
    GetCountyResponse getById(int id);
    void add(AddCountyRequest addCountyRequest);
    void update(int id, UpdateCountyRequest updateCountyRequest) throws Exception;
    void delete(int id);
    List<GetCountyListResponse> findByName(String name);
    GetCountyResponse isNotNull ();
   // List<GetCountyListResponse> findByName1 (String name);

}
