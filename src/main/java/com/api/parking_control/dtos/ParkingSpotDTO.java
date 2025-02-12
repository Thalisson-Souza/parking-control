package com.api.parking_control.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ParkingSpotDTO {

    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String block;

    private CarDTO car;
}
