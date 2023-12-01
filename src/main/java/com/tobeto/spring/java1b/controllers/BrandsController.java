package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.services.abstracts.BrandService;
import com.tobeto.spring.java1b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.java1b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.java1b.entities.Brand;
import com.tobeto.spring.java1b.repositories.BrandRepository;
import com.tobeto.spring.java1b.services.dtos.responses.car.GetCarListResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandsController {
    //Dependency =>  bağımlılık
    //Injection =>  Enjekte
    private final BrandService brandService;
  //final => ctor blok dışında set edemezsiniz.


    @GetMapping
    public List<GetBrandListResponse> getAll(){
        return brandService.getAll();

    }

    //Spring IoC container
    @GetMapping("{id}")
    //Brand yanlış!
    //BrandForDetailDto doğru!
    public GetBrandResponse getById(@PathVariable int id){

      return brandService.getById(id);
    }
    @PostMapping
    //Brand  yanlış!
    //BrandForAddDto  doğru!
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest){
       brandService.update(id,updateBrandRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
      brandService.delete(id);

    }

}
//Request -Response pattern

//her istek için bir request bir response modeli bulunmalıdır

