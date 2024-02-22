package com.example.drone.service;

import com.example.drone.model.Drone;
import com.example.drone.repository.DroneRepository;
import org.springframework.stereotype.Service;


@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public Drone register(Drone drone) {
        return droneRepository.save(drone);
    }
}
