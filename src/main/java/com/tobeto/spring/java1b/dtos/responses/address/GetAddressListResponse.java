package com.tobeto.spring.java1b.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressListResponse {
    private String postalCode;
    private String addressText;
}
