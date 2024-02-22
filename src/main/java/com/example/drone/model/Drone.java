package com.example.drone.model;


import com.example.drone.enums.Model;
import com.example.drone.enums.State;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "drone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
//    @Size(max = 10, message = "Serial number cannot exceed 100 characters")
//    @Column(nullable = false, length = 100, unique = true)
//    @NotBlank(message = "Serial number cannot be blank")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
//    @NotNull(message = "Invalid model")
    private Model model;
//    @Max(value = 500, message = "Weight limit cannot exceed 500 grams")
//    @Min(value = 1, message = "Weight limit should greater or equal to 1")
    private double weightLimit;
//    @Max(value = 100, message = "Battery capacity cannot exceed 100 percentage")
    private double batteryCapacity;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Invalid state")
    private State state;
}
