package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.City;
import com.tobeto.spring.java1b.repositories.CityRepository;
import com.tobeto.spring.java1b.services.abstracts.CityService;
import com.tobeto.spring.java1b.services.dtos.requests.city.AddCityRequest;
import com.tobeto.spring.java1b.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cities")
@AllArgsConstructor
public class CitiesController {

    private final CityService cityService;


    @GetMapping
    public List<GetCityListResponse> getAll(){
      return cityService.getAll();
    }

    @GetMapping("{id}")
    public GetCityResponse getById(@PathVariable int id){
       return  cityService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody @Valid AddCityRequest addCityRequest){
        cityService.add(addCityRequest);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCityRequest updateCityRequest) throws Exception {
       cityService.update(id,updateCityRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        cityService.delete(id);

    }

    @GetMapping("findName")
    public List<GetCityListResponse> findName(@RequestParam String name){
        return cityService.findName(name);
    }

    @GetMapping("findByName")
    public List<GetCityListResponse> findByName(@RequestParam String name){

        return cityService.findByName(name);
    }
    @GetMapping("nameIsNotNull")
    public List<GetCityListResponse> findByNameIsNotNull(){
        return cityService.findByNameIsNotNull();
    }
    @GetMapping("nameIgnoreCase")
    public List<GetCityListResponse> findByNameIgnoreCase(@RequestParam String name){
        return cityService.findByNameIgnoreCase(name);
    }

}
