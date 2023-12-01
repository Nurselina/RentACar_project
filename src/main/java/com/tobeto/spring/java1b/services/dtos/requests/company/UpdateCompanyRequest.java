package com.tobeto.spring.java1b.services.dtos.requests.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyRequest {
    private String name;
    private String address;
    private String contactName;
    private int contactPhone;
}
