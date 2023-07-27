package com.example.drone.service;


import com.example.drone.model.Drone;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


public interface DroneService {

    Object registeringDrone(@Validated Drone drone);
    Optional<Drone> checkingDroneBatteryLevelBySerialNumber(String serialNumber);
    List<Drone> checkingAvailableDronesForLoading();
}
