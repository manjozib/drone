package com.example.drone.dto;

import com.example.drone.enums.Model;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DroneDto {
    @Size(max = 10, message = "Serial number cannot exceed 100 characters")
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "Serial number cannot be blank")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Invalid model")
    private Model model;
    @Max(value = 500, message = "Weight limit cannot exceed 500 grams")
    @Min(value = 1, message = "Weight limit should greater or equal to 1")
    private double weightLimit;
    @Max(value = 100, message = "Battery capacity cannot exceed 100 percentage")
    private double batteryCapacity;
}
