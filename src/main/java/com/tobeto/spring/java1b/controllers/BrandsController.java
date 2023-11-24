package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.java1b.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.java1b.dtos.responses.brand.GetBrandResponse;
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
    //Brand yanlış!
    //BrandForDetailDto doğru!
    public GetBrandResponse getById(@PathVariable int id){

        // Optional<T> => ilgili filtreden bir veri dönmeyebilir
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }
    @PostMapping
    //Brand  yanlış!
    //BrandForAddDto  doğru!
    public void add(@RequestBody AddBrandRequest request){

       //Manuel Mapping => Auto Mapping
        Brand brand=new Brand();
        brand.setName(request.getName());

        brandRepository.save(brand);
    }
    @PutMapping
    public void update(@PathVariable int id,@RequestBody Brand brand){
        brandRepository.findById(brand.getId()).orElseThrow();
        brandRepository.save(brand);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        // kod buraya geliyor ise exception fırlamamıştır..
       // Brand brandToDelete=brandRepository.findById(id).orElseThrow();
       //özel kontroller
        // brandRepository.delete(brandToDelete);
       brandRepository.deleteById(id);

    }

}
//Request -Response pattern

//her istek için bir request bir response modeli bulunmalıdır

