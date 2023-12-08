package com.tobeto.spring.java1b.services.dtos.responses.county;

import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCountyListResponse {
    private String name;
    private GetCityListResponse getCityListResponse;
}
