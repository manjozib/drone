package com.example.drone.model;


import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "drone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    private String serialNumber;
    private Model model;
    private String weightLimit;
    private String batteryCapacity;
    private State state;
}
