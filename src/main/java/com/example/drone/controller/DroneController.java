package com.example.drone.controller;


import com.example.drone.model.Drone;
import com.example.drone.service.DroneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/drone")
public class DroneController {

    @Autowired
    DroneServiceImpl droneService;

    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String registerDrone(@Valid @RequestBody Drone drone) {
        return droneService.registeringDrone(drone);
    }
}
