package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.County;
import com.tobeto.spring.java1b.repositories.CountyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/counties")
public class CountiesController {
    private final CountyRepository countyRepository;

    public CountiesController(CountyRepository countyRepository){
        this.countyRepository =countyRepository;
    }

    @GetMapping
    public List<County> getAll(){
        return countyRepository.findAll();
    }

    @GetMapping("{id}")
    public County getById(@PathVariable int id){
        return countyRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody County county){
        countyRepository.save(county);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody County county){
        countyRepository.findById(county.getId()).orElseThrow();
        countyRepository.save(county);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        countyRepository.deleteById(id);

    }

}
