package com.tobeto.spring.java1b.services.dtos.responses.city;

import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCityListResponse {
    private String name;

}
