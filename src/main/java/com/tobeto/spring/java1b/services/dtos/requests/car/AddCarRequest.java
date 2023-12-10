package com.tobeto.spring.java1b.services.dtos.requests.car;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotNull(message = "Model yılı boş geçilemez.")
    private int modelYear;
    private String modelName;
}
