package com.example.drone.service;


import com.example.drone.dto.LoadDroneDto;
import com.example.drone.model.Drone;

import java.util.List;
import java.util.Optional;


public interface DroneService {

    Object registeringDrone(Drone drone);
    Optional<Drone> checkingDroneBatteryLevelBySerialNumber(String serialNumber);
    List<Drone> checkingAvailableDronesForLoading();
    String loadDroneWithMedication(LoadDroneDto loadDroneDto);
    String checkLoadedMedicationToADrone(String serialNumber);
}
