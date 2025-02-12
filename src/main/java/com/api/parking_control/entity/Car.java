package com.api.parking_control.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car")

@Getter
@Setter
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "responsibleCar")
    @NotBlank
    private String responsibleCar;

    @Column(name = "plateCar")
    @NotBlank
    private String plateCar;

    @Column(name = "modelCar")
    @NotBlank
    private String modelCar;

    @Column(name = "colorCar")
    @NotBlank
    private String colorCar;
}
