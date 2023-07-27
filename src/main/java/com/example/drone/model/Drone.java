package com.example.drone.model;


import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "drone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    @Id
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    private double weightLimit;
    private double batteryCapacity;
    @Enumerated(EnumType.STRING)
    private State state;
}
