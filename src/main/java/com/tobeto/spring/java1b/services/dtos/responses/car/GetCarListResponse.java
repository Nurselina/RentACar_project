package com.tobeto.spring.java1b.services.dtos.responses.car;

import com.tobeto.spring.java1b.entities.Brand;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private String modelName;
    private double price;
    private String fuelType;
    private GetBrandListResponse brand;
}
