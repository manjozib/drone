package com.example.drone.repository;

import com.example.drone.model.LoadLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoadLinesRepository extends JpaRepository<LoadLines, Long> {

    @Query(
            value = "SELECT SUM(total_Weight) FROM Load " +
            " WHERE drone_serial_number = :droneSerialNumber",
            nativeQuery = true
    )
    double getTotalWeightOfLoadedItemsForDroneBySerialNumber(String droneSerialNumber);
}
