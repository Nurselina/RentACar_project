package com.tobeto.spring.java1b.services.dtos.responses.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyResponse {
    private String contactName;
    private int contactPhone;
}
