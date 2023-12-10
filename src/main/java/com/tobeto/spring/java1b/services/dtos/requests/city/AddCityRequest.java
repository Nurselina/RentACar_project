package com.tobeto.spring.java1b.services.dtos.requests.city;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    @NotEmpty(message = "Alan boş geçilemez.")
    private String name;
}
