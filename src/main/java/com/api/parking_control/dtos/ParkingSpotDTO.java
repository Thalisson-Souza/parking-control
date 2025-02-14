package com.api.parking_control.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ParkingSpotDTO(
    @NotBlank
    String parkingSpotNumber,
    @NotBlank
    String responsibleName,
    @NotBlank
    String block,
    @NotNull
    CarDTO car
    )
{}
