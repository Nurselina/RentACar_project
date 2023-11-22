package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.Brand;
import com.tobeto.spring.java1b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/brands")
public class BrandsController {
    //Dependency =>  bağımlılık
    //Injection =>  Enjekte
    private final BrandRepository brandRepository;
  //final => ctor blok dışında set edemezsiniz.
    public BrandsController(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }
    @GetMapping
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    //Spring IoC container
    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        return brandRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }
    @PutMapping
    public void update(@RequestBody Brand brand){
        brandRepository.findById(brand.getId()).orElseThrow();
        brandRepository.save(brand);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       // Brand brandToDelete=brandRepository.findById(id).orElseThrow();
       // brandRepository.delete(brandToDelete);
       brandRepository.deleteById(id);

    }

}
