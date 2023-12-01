package com.tobeto.spring.java1b.services.dtos.responses.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyListResponse {
    private String name;
    private String address;
    private String contactName;
    private int contactphone;
}
