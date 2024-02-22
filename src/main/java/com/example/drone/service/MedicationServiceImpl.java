package com.example.drone.service;

import com.example.drone.model.Medication;
import com.example.drone.repository.MedicationRepository;
import org.springframework.stereotype.Service;


@Service
public class MedicationServiceImpl implements MedicationService{

    private final MedicationRepository medicationRepository;

    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Medication add(Medication medication) {
        if(medication.getWeight() <= 0) {
            throw new RuntimeException("Weight must be greater than zero");
        }
        return medicationRepository.save(medication);
    }
}
