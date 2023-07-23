package com.example.drone.service;

import com.example.drone.model.Medication;
import com.example.drone.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicationServiceImpl implements MedicationService{


    @Autowired
    MedicationRepository medicationRepository;

    @Override
    public String loadMedication(Medication medication) {

        medicationRepository.save(medication);
        return "medication saved successfully";
    }
}
