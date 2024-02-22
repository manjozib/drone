package com.example.drone.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
@Data
public class LoadLinesDto {
    @Size(max = 10, message = "Serial number cannot exceed 100 characters")
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "Serial number cannot be blank")
    private String droneSerialNumber;
    private List<LoadMedicationDto> loadMedicationDtoList;
}
