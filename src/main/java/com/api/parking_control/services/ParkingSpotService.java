package com.api.parking_control.services;

import com.api.parking_control.dtos.ParkingSpotDTO;
import com.api.parking_control.entity.Car;
import com.api.parking_control.entity.ParkingSpot;
import com.api.parking_control.repository.CarRepository;
import com.api.parking_control.repository.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ParkingSpotService {

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
}
