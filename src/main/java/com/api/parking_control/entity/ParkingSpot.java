package com.api.parking_control.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "parking-spot")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "parkingSpotNumber", unique = true)
    @NotBlank
    private String parkingSpotNumber;

    @Column(name = "responsibleName", unique = true)
    @NotBlank
    private String responsibleName;

    @Column(name = "apartment/block", unique = true)
    @NotBlank
    private String block;

    @Column(name = "date_register")
    @NotBlank
    private LocalDateTime registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
