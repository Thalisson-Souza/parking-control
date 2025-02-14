package com.api.parking_control.services;

import com.api.parking_control.entity.ParkingSpot;
import com.api.parking_control.repository.CarRepository;
import com.api.parking_control.repository.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

@Service
public class    ParkingSpotService {

    ParkingSpotRepository parkingSpotRepository;
    private final CarRepository carRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository,
                              CarRepository carRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.carRepository = carRepository;
    }

    @Transactional
    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot){
        return parkingSpotRepository.save(parkingSpot);
    }

    public boolean existsByCarPlateCar(@NotBlank String licensePlateCar){
        return parkingSpotRepository.existsByCarPlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(@NotBlank String spotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(spotNumber);
    }

    public boolean existsByBlock(@NotBlank String blockSpotId) {
        return parkingSpotRepository.existsByBlock(blockSpotId);
    }
}
