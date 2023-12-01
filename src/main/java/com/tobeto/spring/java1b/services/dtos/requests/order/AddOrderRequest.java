package com.tobeto.spring.java1b.services.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private double amount;
    private LocalDate date;
    private LocalDate starRent;
    private LocalDate endRent;
}
