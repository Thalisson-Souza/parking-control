package com.api.parking_control.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")

@Getter
@Setter
@AllArgsConstructor
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "parkingSpotNumber", unique = true, nullable = false)
    @NotNull
    private String parkingSpotNumber;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Car car;

    @Column(name = "date_register")
    private LocalDateTime registrationDate;

    @Getter
    @Column(name = "responsibleName", unique = true,nullable = false)
    @NotNull
    private String responsibleName;

    @Getter
    @Column(name = "apartment", unique = true,nullable = false)
    @NotNull
    private String block;




    public ParkingSpot() {
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public UUID getId() {
        return id;
    }

}
