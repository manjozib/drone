package com.example.drone.controller;


import com.example.drone.dao.Dao;
import com.example.drone.dao.LoadedDrone;
import com.example.drone.dto.LoadDroneDto;
import com.example.drone.model.Drone;
import com.example.drone.model.Medication;
import com.example.drone.service.DroneServiceImpl;
import com.example.drone.service.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drone")
public class DroneController {

    @Autowired
    DroneServiceImpl droneService;

    @Autowired
    MedicationServiceImpl medicationService;

    List<LoadDroneDto> loadedDrones = new ArrayList<>();


    static class GenericForNotFoundResource {
        public String message;

        public GenericForNotFoundResource(String message) {
            this.message = message;
        }
    }

    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public Object registerDrone(@Valid @RequestBody Drone drone) {
        return droneService.registeringDrone(drone);
    }

    @RequestMapping(value = "/check-battery-percentage", method = RequestMethod.POST)
    public ResponseEntity<?> checkPercentage(@RequestBody Dao checkBatteryPercentageDao) {
        Optional<Drone> droneOptional =
                droneService.checkingDroneBatteryLevelBySerialNumber(checkBatteryPercentageDao.getSerialNumber());

        class Battery{
            public final double battery;
            public final String serialNumber;

            public Battery(double battery, String serialNumber) {
                this.battery = battery;
                this.serialNumber = serialNumber;
            }
        }


        if(droneOptional.isPresent()) {
            return new ResponseEntity<>(new Battery(droneOptional.get().getBatteryCapacity(),
                    checkBatteryPercentageDao.getSerialNumber()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericForNotFoundResource("Drone with serial Number " +
                    checkBatteryPercentageDao.getSerialNumber() + " not found"), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/loading", method = RequestMethod.GET)
    public ResponseEntity<?> checkDronesThatCanBeLoaded() {

        if (droneService.checkingAvailableDronesForLoading().size() > 0) {
            return new ResponseEntity<>(
                    droneService.checkingAvailableDronesForLoading(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new GenericForNotFoundResource("Not found"), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/load-medication", method = RequestMethod.POST)
    public ResponseEntity<Object> loadMedication(@RequestBody LoadDroneDto loadDroneDto) {
        loadedDrones.add(loadDroneDto);
        return new ResponseEntity<>(new GenericForNotFoundResource("Loaded"), HttpStatus.OK);
    }

}
