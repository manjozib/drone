package com.example.drone.service.impl;

import com.example.drone.dto.ChangeStateDto;
import com.example.drone.dto.DroneDto;
import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import com.example.drone.model.Drone;
import com.example.drone.repository.DroneRepository;
import com.example.drone.service.DroneService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public void register(DroneDto droneDto) {

        Model model = Model.valueOf(droneDto.getModel().toString());
        droneRepository.save(
                new Drone(
                        "", droneDto.getSerialNumber(),
                        model, droneDto.getWeightLimit(),
                        droneDto.getBatteryCapacity(), State.IDLE
                )
        );
    }

    @Override
    public void changeDroneState(ChangeStateDto changeStateDto) {
        Optional<Drone> searchExistenceBySerial = droneRepository
                .findBySerialNumber(changeStateDto.getSerialNumber());
        if(searchExistenceBySerial.isPresent()) {
            //State state = State.valueOf(String.valueOf(changeStateDto.getState()));
            droneRepository.updateDroneState(changeStateDto.getSerialNumber(), String.valueOf(changeStateDto.getState()));
        } else {
            throw new RuntimeException("Drone of serial#: " + changeStateDto.getSerialNumber() + " does not exist");
        }
    }
}
