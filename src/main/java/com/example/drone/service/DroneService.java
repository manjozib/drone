package com.example.drone.service;

import com.example.drone.dto.ChangeStateDto;
import com.example.drone.dto.DroneDto;
import com.example.drone.model.Drone;
import org.aspectj.apache.bcel.classfile.Module;

import java.util.Optional;

public interface DroneService {

    void register(DroneDto droneDto);
    void changeDroneState(ChangeStateDto changeStateDto);
    Drone searchDroneExistence(String serial);
}
