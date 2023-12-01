package com.tobeto.spring.java1b.services.dtos.requests.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookingRequest {
    private LocalDate startDate;
    private LocalDate endDate;
}
