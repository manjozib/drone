package com.example.drone.model;


import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "drone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    @Id
    @Size(max = 2)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    private double weightLimit;
    private double batteryCapacity;
    @Enumerated(EnumType.STRING)
    private State state;
}
