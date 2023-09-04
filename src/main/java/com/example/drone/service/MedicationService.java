package com.example.drone.service;

import com.example.drone.model.Medication;

import java.util.List;
import java.util.Optional;

public interface MedicationService {

    String loadMedication(Medication medication);

    List<Medication> getAllMedications();

    double getWeightOfMedicationByCode(String code);

}
