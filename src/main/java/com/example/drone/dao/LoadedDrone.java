package com.example.drone.dao;

import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import com.example.drone.model.Medication;

import java.util.List;

public class LoadedDrone {

    private Model model;
    private double weightLimit;
    private double batteryCapacity;
    private State state;
    private List<Medication> medicationList;

}
