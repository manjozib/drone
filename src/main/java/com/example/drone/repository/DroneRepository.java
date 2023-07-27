package com.example.drone.repository;

import com.example.drone.enums.State;
import com.example.drone.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, String> {

    List<Drone> findAllDronesByState(State state);
}
