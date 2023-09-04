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
    //@Size(max = 100, message = "Serial number cannot exceed 100 characters")
    //@Column(nullable = false, length = 100, unique = true)
    //@NotBlank(message = "Serial number cannot be blank")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    //@Max(value = 500, message = "Weight limit cannot exceed 500 grams")
    private double weightLimit;
   // @Max(value = 100, message = "Weight limit cannot exceed 100 percentage")
    private double batteryCapacity;
    @Enumerated(EnumType.STRING)
    private State state;
}
