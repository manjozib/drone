package com.example.drone.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class LoadMedicationDto {

    @Pattern(regexp="^[A-Z0-9_]+$",message="allowed only upper case letters, underscore and numbers")
    private String medicalCode;
    @Min(value = 1, message = "Weight limit should greater or equal to 1")
    private int quantityOfMedication;
}
