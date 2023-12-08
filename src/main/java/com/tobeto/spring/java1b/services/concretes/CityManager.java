package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.City;
import com.tobeto.spring.java1b.repositories.CityRepository;
import com.tobeto.spring.java1b.services.abstracts.CityService;
import com.tobeto.spring.java1b.services.dtos.requests.city.AddCityRequest;
import com.tobeto.spring.java1b.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<GetCityListResponse> getAll() {
        List<City> cityList=cityRepository.findAll();
        List<GetCityListResponse> getCityListResponses=new ArrayList<>();
        for (City city:cityList){
            GetCityListResponse response=new GetCityListResponse();
            response.setName(city.getName());
            getCityListResponses.add(response);
        }
        return getCityListResponses;
    }

    @Override
    public GetCityResponse getById(int id) {
        City city=cityRepository.findById(id).orElseThrow();
        GetCityResponse getCityResponse=new GetCityResponse();
        getCityResponse.setName(city.getName());

        return getCityResponse;
    }

    @Override
    public void add(AddCityRequest addCityRequest) {
        City city=new City();
        city.setName(addCityRequest.getName());
        cityRepository.save(city);
    }

    @Override
    public void update(int id, UpdateCityRequest updateCityRequest) throws Exception {
        Optional<City> optionalCity= cityRepository.findById(id);

        if(optionalCity.isPresent()){
            City city=optionalCity.get();
            city.setName(updateCityRequest.getName());
            cityRepository.save(city);
        }else {
            throw new Exception("Güncellenemedi.");
        }
    }

    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<GetCityListResponse> findName(String name) {
        List<City> cityList=cityRepository.findByNameIsContaining(name);
        List<GetCityListResponse> getCityListResponses=new ArrayList<>();
        for (City city:cityList){
            GetCityListResponse response=new GetCityListResponse();
            response.setName(city.getName());
            getCityListResponses.add(response);
        }
        return getCityListResponses ;
    }

    @Override
    public List<GetCityListResponse> findByName(String name) {
        List<City> cityList=cityRepository.findByName(name);
        List<GetCityListResponse> getCityListResponses=new ArrayList<>();
        for (City city:cityList){
            GetCityListResponse response=new GetCityListResponse();
            response.setName(city.getName());
            getCityListResponses.add(response);
        }
        return getCityListResponses;
    }

}
