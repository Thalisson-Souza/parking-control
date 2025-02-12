package com.api.parking_control.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarDTO {
    @NotBlank
    private String responsibleCar;

    @NotBlank
    private String plateCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String colorCar;
}
