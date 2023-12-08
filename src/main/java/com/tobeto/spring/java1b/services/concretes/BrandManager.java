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
      //if(request.getName().length() <2)
         // throw new RuntimeException( "Marka adı 2 haneden kısa olamaz.");
      //Aynı isimde iki brand olamaz

        //Kural : Metodun en başına iş kuralları ekle. Hata fırlatırsa alt kodu çalıştırmasın.
       List<Brand> brandWithSameName =brandRepository.findByName(request.getName().trim());

       /*if (brandWithSameName.size() > 0 ){
           throw  new RuntimeException("Aynı isimle iki marka eklenemez.");
       }*/
        if (brandRepository.existsByName(request.getName().trim()))
        {
            throw  new RuntimeException("Aynı isimle iki marka eklenemez.");
        }

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

    @Override
    public List<GetBrandListResponse> getByName(String name, int id) {
        List<Brand> brands = brandRepository.findByNameLikeOrIdEquals("%"+name+"%", id);
        List<GetBrandListResponse> response= new ArrayList<>();

        for (Brand brand : brands) {
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return response;
    }

    @Override
    public List<Brand> search(String name) {
        return brandRepository.search(name);
    }

    @Override
    public List<Brand> search2(String name) {
        return brandRepository.search2(name);
    }

    @Override
    public List<GetBrandListResponse> search3(String name) {
        return brandRepository.search3(name);
    }
}
