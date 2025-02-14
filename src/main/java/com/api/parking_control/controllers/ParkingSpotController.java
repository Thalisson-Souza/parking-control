package com.api.parking_control.controllers;

import com.api.parking_control.dtos.ParkingSpotDTO;
import com.api.parking_control.entity.Car;
import com.api.parking_control.entity.ParkingSpot;
import com.api.parking_control.repository.CarRepository;
import com.api.parking_control.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    ParkingSpotService parkingSpotService;
    private final CarRepository carRepository;

    public ParkingSpotController(ParkingSpotService parkingSpotService,CarRepository carRepository) {
        this.parkingSpotService = parkingSpotService;
        this.carRepository = carRepository;
    }

    @PostMapping
    public ResponseEntity<Object> createParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
        var car = new Car();
        car.setPlateCar(parkingSpotDTO.car().plateCar());
        car.setModelCar(parkingSpotDTO.car().modelCar());
        car.setColorCar(parkingSpotDTO.car().colorCar());
        car = carRepository.save(car);

        var parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotNumber(parkingSpotDTO.parkingSpotNumber());
        parkingSpot.setResponsibleName(parkingSpotDTO.responsibleName());
        parkingSpot.setBlock(parkingSpotDTO.block());
        parkingSpot.setRegistrationDate(LocalDateTime.now());
        parkingSpot.setCar(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.createParkingSpot(parkingSpot));
    }
}
