package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.County;
import com.tobeto.spring.java1b.repositories.CountyRepository;
import com.tobeto.spring.java1b.services.abstracts.CountyService;
import com.tobeto.spring.java1b.services.dtos.requests.county.AddCountyRequest;
import com.tobeto.spring.java1b.services.dtos.requests.county.UpdateCountyRequest;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountyManager implements CountyService {
    private final CountyRepository countyRepository;
    @Override
    public List<GetCountyListResponse> getAll() {
        List<County> countyList =countyRepository.findAll();
        List<GetCountyListResponse> getCountyListResponses=new ArrayList<>();
        for (County county:countyList){
            GetCountyListResponse response=new GetCountyListResponse();
            response.setName(county.getName());
            getCountyListResponses.add(response);
        }

        return getCountyListResponses;
    }

    @Override
    public GetCountyResponse getById(int id) {
        County county=countyRepository.findById(id).orElseThrow();
        GetCountyResponse getCountyResponse=new GetCountyResponse();
        getCountyResponse.setName(county.getName());
        return getCountyResponse;
    }

    @Override
    public void add(AddCountyRequest addCountyRequest) {
        County county=new County();
        county.setName(addCountyRequest.getName());
        countyRepository.save(county);
    }

    @Override
    public void update(int id, UpdateCountyRequest updateCountyRequest) throws Exception {
        Optional<County> optionalCounty=countyRepository.findById(id);
        if (optionalCounty.isPresent()){
            County county=optionalCounty.get();
            county.setName(updateCountyRequest.getName());
            countyRepository.save(county);
        }else {
            throw new Exception("Güncellenemedi.");
        }
    }

    @Override
    public void delete(int id) {
        countyRepository.deleteById(id);
    }

    @Override
    public List<GetCountyListResponse> findByName(String name) {
        List<County> countyList= countyRepository.findByNameEndingWith(name);
        List<GetCountyListResponse> getCountyListResponses =new ArrayList<>();
        for (County county: countyList){
            GetCountyListResponse response= new GetCountyListResponse();
            GetCityListResponse getCityListResponse = new GetCityListResponse(county.getCity().getName());
            response.setName(county.getName());
            response.setGetCityListResponse(getCityListResponse);
            getCountyListResponses.add(response);

        }
        return getCountyListResponses;
    }

    @Override
    public GetCountyResponse isNotNull() {
        County county=countyRepository.findFirstByNameIsNotNull();
        GetCountyResponse countyResponse=new GetCountyResponse();
        countyResponse.setName(county.getName());
        return countyResponse;
    }

  /*  @Override
    public List<GetCountyListResponse> findByName1(String name) {
        return countyRepository.findByName1(name);
    }*/
}
