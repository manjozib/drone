package com.example.drone.model;


import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Size(max = 10, message = "Serial number cannot exceed 100 characters")
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "Serial number cannot be blank")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Invalid model")
    private Model model;
    @Max(value = 500, message = "Weight limit cannot exceed 500 grams")
    private double weight;
    @Max(value = 100, message = "Battery capacity cannot exceed 100 percentage")
    private double batteryCapacity;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Invalid state")
    private State state;
}
