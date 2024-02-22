package com.example.drone.repository;

import com.example.drone.enums.State;
import com.example.drone.model.Drone;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone, String> {

//    List<Drone> findAllDronesByState(State state);
//    @Query(value = "SELECT * FROM Drone WHERE state IN ('LOADING', 'IDLE')",
//            nativeQuery = true)
//    List<Drone> findAllDronesWhichAreIdleAndLoading();

    Optional<Drone> findBySerialNumber(String serialNumber);
    @Transactional
    @Modifying
    @Query(
            value = "UPDATE Drone SET state = :state " +
                    "WHERE serial_number = :serialNumber",
            nativeQuery = true
    )
    void updateDroneState(String serialNumber, String state);
}
