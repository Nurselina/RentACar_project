package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.County;
import com.tobeto.spring.java1b.repositories.CountyRepository;
import com.tobeto.spring.java1b.services.abstracts.CountyService;
import com.tobeto.spring.java1b.services.dtos.requests.county.AddCountyRequest;
import com.tobeto.spring.java1b.services.dtos.requests.county.UpdateCountyRequest;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/counties")
@AllArgsConstructor
public class CountiesController {
    private final CountyService countyService;

    @GetMapping
    public List<GetCountyListResponse> getAll(){
       return countyService.getAll();
    }

    @GetMapping("{id}")
    public GetCountyResponse getById(@PathVariable int id){
       return countyService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCountyRequest addCountyRequest){
       countyService.add(addCountyRequest);

    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCountyRequest updateCountyRequest) throws Exception {
       countyService.update(id,updateCountyRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        countyService.delete(id);

    }
    @GetMapping("findByName")
    public List<GetCountyListResponse> findByName(@RequestParam String name){
       return countyService.findByName(name);
    }
    @GetMapping("isNotNull")
    public GetCountyResponse isNotNull(){

        return countyService.isNotNull();
    }

}
