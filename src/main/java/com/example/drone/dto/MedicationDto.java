package com.example.drone.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class MedicationDto {

    @Pattern(regexp="^[a-zA-Z0-9-_]+$",message="Allowed only letters, numbers, ‘-‘, ‘_’")
    private String name;
    @Column(nullable = false)
    private double weight;
    @Pattern(regexp="^[A-Z0-9_]+$",message="allowed only upper case letters, underscore and numbers")
    private String code;
}
