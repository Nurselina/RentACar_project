package com.tobeto.spring.java1b.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private int drivingLicanseNo;
    private  String  firstName;
    private String lastName;
    private int phone;
    private String email;
}
