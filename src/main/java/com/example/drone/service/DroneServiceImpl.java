package com.example.drone.service;

import com.example.drone.dao.LoadedDrone;
import com.example.drone.dto.LoadDroneDto;
import com.example.drone.dto.MedicationDto;
import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import com.example.drone.model.Drone;
import com.example.drone.model.Medication;
import com.example.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DroneServiceImpl implements DroneService{


    private final DroneRepository droneRepository;

    private final MedicationServiceImpl medicationService;

    public DroneServiceImpl(DroneRepository droneRepository, MedicationServiceImpl medicationService) {
        this.droneRepository = droneRepository;
        this.medicationService = medicationService;
    }

    List<LoadedDrone> loadedDrones;

    class Object {
        public String message;

        public Object(String message) {
            this.message = message;
        }
    }

    @Override
    public java.lang.Object registeringDrone(Drone drone) {

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
        return droneRepository.findAllDronesByState(State.IDLE)
                .stream()
                .filter(drone -> drone.getBatteryCapacity() > 25)
                .collect(Collectors.toList());
    }

    @Override
    public List<Drone> getAll() {
        return droneRepository.findAll();
    }

    @Override
    public void validatation(Drone drone) {
        if (drone.getSerialNumber().length() > 100
                || drone.getSerialNumber().length() < 1) {
            throw new RuntimeException("serial number (100 characters max)");
        }
    }

    @Override
    public String loadDroneWithMedication(LoadDroneDto loadDroneDto) {

        String model;
        double weightLimit;
        double batteryCapacity;
        //String state;
        List<Medication> medicationList;

        List<Drone> droneAvailableForLoading= checkingAvailableDronesForLoading();
        List<String> dronesSerials = new ArrayList<>();
        for (Drone drone: droneAvailableForLoading) {
           dronesSerials.add(drone.getSerialNumber());
        }

        int weightOfMedications = 0;
        for (MedicationDto load: loadDroneDto.getMedication()) {
            weightOfMedications += medicationService.getWeightOfMedicationByCode(load.getCode());
        }

        //if (weightOfMedications > droneRepository) {}


        if (dronesSerials.contains(loadDroneDto.getSerialNumber())) {
            Optional<Drone> drone = droneRepository.findById(loadDroneDto.getSerialNumber());
            if (drone.isPresent()) {
                model = drone.get().getModel().toString();
                weightLimit = drone.get().getWeightLimit();
                batteryCapacity = drone.get().getBatteryCapacity();


            }




        }


        return null;
    }
    @Override
    public String checkLoadedMedicationToADrone(String serialNumber) {
        return null;
    }
}
