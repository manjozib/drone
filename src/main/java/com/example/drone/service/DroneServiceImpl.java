package com.example.drone.service;

import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import com.example.drone.model.Drone;
import com.example.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;


@Service
public class DroneServiceImpl implements DroneService{

    @Autowired
    DroneRepository droneRepository;

    @Override
    public String registeringDrone(@Validated Drone drone) {
        if(drone.getSerialNumber().length() > 100) {
            return "Serial number must be less than 100 characters";
        } else if (drone.getBatteryCapacity() < 0 || drone.getBatteryCapacity() > 100) {
            return "Battery Capacity must be between 0 and 100";
        } else if((drone.getWeightLimit() < 0 || drone.getWeightLimit() > 500)) {
            return "Weight Limit must be between 0 and 500";
        }  else {
            try {
                Arrays.asList("Lightweight", "Middleweight", "Cruiserweight", "Heavyweight").contains(
                        String.valueOf(Model.decode(drone.getModel().toString())));
            } catch (NullPointerException nullPointerException) {
                return "Model must be in the following list [\"Lightweight\", \"Middleweight\", \"Cruiserweight\", \"Heavyweight\"]";
            }
            try {
                Arrays.asList("IDLE", "LOADING", "LOADED", "DELIVERING", "DELIVERED", "RETURNING").contains(
                        String.valueOf(State.decode(drone.getState().toString()))
                );
            } catch (NullPointerException nullPointerException) {
                return "State must be in the following list [\"IDLE\", \"LOADING\", \"LOADED\", \"DELIVERING\", \"DELIVERED\", \"RETURNING\"]";
            }
        }
        droneRepository.save(drone);
        return "Drone of od serial Number: " + drone.getSerialNumber() + "has registered";
    }
}
