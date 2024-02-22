package com.example.drone.service;

import com.example.drone.dto.ChangeStateDto;
import com.example.drone.dto.DroneDto;

public interface DroneService {

    void register(DroneDto droneDto);
    void changeDroneState(ChangeStateDto changeStateDto);
}
