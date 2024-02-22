package com.example.drone.controller;


import com.example.drone.model.Drone;
import com.example.drone.service.DroneServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.beans.BeanInfo;

@RestController
@RequestMapping(value = "/drone")
public class DroneController {

    private final DroneServiceImpl droneService;

    public DroneController(DroneServiceImpl droneService) {
        this.droneService = droneService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> registerDrone(@Valid @RequestBody Drone drone, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>("Failed to register because: " + bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        try {
            droneService.register(drone);

            return new ResponseEntity<>("Drone Registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Drone Failed to register", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
