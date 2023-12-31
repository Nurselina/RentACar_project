package com.tobeto.spring.java1b.services.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    private String firstName;
    private String lastName;
    private int phone;
}
