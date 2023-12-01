package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.Brand;
import com.tobeto.spring.java1b.repositories.BrandRepository;
import com.tobeto.spring.java1b.services.abstracts.BrandService;
import com.tobeto.spring.java1b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.java1b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
  private final BrandRepository brandRepository;


    @Override
    public void add(AddBrandRequest request) {
      if(request.getName().length() <2)
          throw new RuntimeException( "Marka adı 2 haneden kısa olamaz.");

           Brand brand =new Brand();
           brand.setName(request.getName());

           brandRepository.save(brand);
    }

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponses = new ArrayList<>();
        for (Brand brand:brands) {
            GetBrandListResponse getBrandListResponse = new GetBrandListResponse();
            getBrandListResponse.setName(brand.getName());
            getBrandListResponses.add(getBrandListResponse);
        }
        return getBrandListResponses;
    }

    @Override

    public GetBrandResponse getById(int id) {
        // Optional<T> => ilgili filtreden bir veri dönmeyebilir
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

    @Override
    public void update(int id, UpdateBrandRequest updateBrandRequest) {
        Brand brand= brandRepository.findById(id).orElseThrow();
        brand.setName(updateBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        // kod buraya geliyor ise exception fırlamamıştır..
        // Brand brandToDelete=brandRepository.findById(id).orElseThrow();
        //özel kontroller
        // brandRepository.delete(brandToDelete);
        brandRepository.deleteById(id);
    }
}
