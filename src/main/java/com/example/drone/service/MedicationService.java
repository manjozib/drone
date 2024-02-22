package com.example.drone.service;

import com.example.drone.dto.MedicationDto;
import com.example.drone.model.Medication;

public interface MedicationService {

    Medication add(MedicationDto medicationDto);

    Medication searchExistenseByCode(String code);
}
