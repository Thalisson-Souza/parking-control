package com.api.parking_control.controllers;

import com.api.parking_control.dtos.ParkingSpotDTO;
import com.api.parking_control.entity.Car;
import com.api.parking_control.entity.ParkingSpot;
import com.api.parking_control.repository.CarRepository;
import com.api.parking_control.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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
        if(parkingSpotService.existsByCarPlateCar(parkingSpotDTO.car().plateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: plate Car is in use for other people");
        }
        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.parkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot Number in use");
        }
        if(parkingSpotService.existsByBlock(parkingSpotDTO.block())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Block/Apartment has ben used");
        }

        var car = new Car();
        BeanUtils.copyProperties(parkingSpotDTO.car(), car);
        car = carRepository.save(car);

        var parkingSpot = new ParkingSpot();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpot);
        parkingSpot.setRegistrationDate(LocalDateTime.now());
        parkingSpot.setCar(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.createParkingSpot(parkingSpot));
    }
}
