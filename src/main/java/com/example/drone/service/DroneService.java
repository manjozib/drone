package com.example.drone.service;


import com.example.drone.model.Drone;
import org.springframework.validation.annotation.Validated;


public interface DroneService {

    String registeringDrone(@Validated Drone drone);
}
