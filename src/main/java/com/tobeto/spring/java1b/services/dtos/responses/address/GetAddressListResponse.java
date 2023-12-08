package com.tobeto.spring.java1b.services.dtos.responses.address;

import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.county.GetCountyListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressListResponse {
    private String postalCode;
    private String addressText;
    private GetCityListResponse getCityListResponse;
}
