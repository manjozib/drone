package com.example.drone.service;

import com.example.drone.model.Drone;
import com.example.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DroneServiceImpl implements DroneService{

    @Autowired
    DroneRepository droneRepository;

    @Override
    public String registeringDrone(Drone drone) {

        droneRepository.save(drone);
        return "Drone of od serial Number: " + drone.getSerialNumber() + "has registered";
    }
}
