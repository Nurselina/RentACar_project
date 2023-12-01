package com.tobeto.spring.java1b.services.dtos.responses.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBookingResponse {
    private LocalDate startDate;
    private LocalDate endDate;
}
