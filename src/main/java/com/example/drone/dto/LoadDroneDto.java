package com.example.drone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoadDroneDto {

    private String serialNumber;
    private List<MedicationDto> medication;

}
