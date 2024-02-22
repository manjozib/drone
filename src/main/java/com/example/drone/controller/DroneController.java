package com.example.drone.controller;


import com.example.drone.dto.ChangeStateDto;
import com.example.drone.dto.DroneDto;
import com.example.drone.model.Drone;
import com.example.drone.service.impl.DroneServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/drone")
public class DroneController {

    private final DroneServiceImpl droneService;

    public DroneController(DroneServiceImpl droneService) {
        this.droneService = droneService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> registerDrone(@Valid @RequestBody DroneDto droneDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>("Failed to register because: " + bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        try {
            droneService.register(droneDto);

            return new ResponseEntity<>("Drone Registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Drone Failed to register", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/update-state", method = RequestMethod.POST)
    public ResponseEntity<Object> changeState(@Valid @RequestBody ChangeStateDto changeStateDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>("Failed to change drone state because: " + bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        try {
            droneService.changeDroneState(changeStateDto);

            return new ResponseEntity<>("Drone state updated successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Drone Failed to update its state", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
