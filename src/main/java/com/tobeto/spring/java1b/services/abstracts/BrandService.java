package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.entities.Brand;
import com.tobeto.spring.java1b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.java1b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void update(int id, UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
