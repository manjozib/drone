package com.example.drone.service;

import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import com.example.drone.model.Drone;
import com.example.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class DroneServiceImpl implements DroneService{

    @Autowired
    DroneRepository droneRepository;

    class Object {
        public String message;

        public Object(String message) {
            this.message = message;
        }
    }

    @Override
    public java.lang.Object registeringDrone(@Validated Drone drone) {
        if(drone.getSerialNumber().length() > 100) {
            return new Object("Serial number must be less than 100 characters");
        } else if (drone.getBatteryCapacity() < 0 || drone.getBatteryCapacity() > 100) {
            return new Object("Battery Capacity must be between 0 and 100");
        } else if((drone.getWeightLimit() < 0 || drone.getWeightLimit() > 500)) {
            return new Object("Weight Limit must be between 0 and 500");
        }  else {
            try {
                Arrays.asList("Lightweight", "Middleweight", "Cruiserweight", "Heavyweight").contains(
                        String.valueOf(Model.decode(drone.getModel().toString())));
            } catch (NullPointerException nullPointerException) {
                return new Object("Model must be in the following list [\"Lightweight\", " +
                        "\"Middleweight\", \"Cruiserweight\", \"Heavyweight\"]");
            }
            try {
                Arrays.asList("IDLE", "LOADING", "LOADED", "DELIVERING", "DELIVERED", "RETURNING").contains(
                        String.valueOf(State.decode(drone.getState().toString()))
                );
            } catch (NullPointerException nullPointerException) {
                return new Object("State must be in the following list [\"IDLE\", \"LOADING\"," +
                        " \"LOADED\", \"DELIVERING\", \"DELIVERED\", \"RETURNING\"]");
            }
        }
        droneRepository.save(drone);
        return new Object("Drone of serial Number: " + drone.getSerialNumber() + " has registered");
    }

    @Override
    public Optional<Drone> checkingDroneBatteryLevelBySerialNumber(String serialNumber) {

        return droneRepository.findById(serialNumber);
    }

    @Override
    public List<Drone> checkingAvailableDronesForLoading() {
        return droneRepository.findAllDronesByState(State.IDLE);
    }
}
