package com.example.drone.repository;

import com.example.drone.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoadRepository extends JpaRepository<Load, Long> {

    @Query(
            value = "SELECT SUM(total_Weight) FROM Load " +
            " WHERE drone_Serial_Number = :droneSerialNumber",
            nativeQuery = true
    )
    double getTotalWeightOfLoadedItemsForDroneBySerialNumber(String droneSerialNumber);
}
