package com.example.drone.service;

import com.example.drone.model.Medication;

import java.util.List;

public interface MedicationService {

    String loadMedication(Medication medication);

    List<Medication> getAllMedications();

}
