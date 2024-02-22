package com.example.drone.service.impl;

import com.example.drone.dto.MedicationDto;
import com.example.drone.model.Drone;
import com.example.drone.model.Medication;
import com.example.drone.repository.MedicationRepository;
import com.example.drone.service.MedicationService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Medication add(MedicationDto medicationDto) {

        if(medicationDto.getWeight() <= 0) {
            throw new RuntimeException("Weight must be greater than zero");
        }

        return medicationRepository.save(
                new Medication(
                        "", medicationDto.getName(),
                        medicationDto.getWeight(),
                        medicationDto.getCode()
                )
        );
    }

    @Override
    public Medication searchExistenseByCode(String code) {
        Optional<Medication> searchExistenceByCode = medicationRepository
                .findByCode(code);
        return searchExistenceByCode.orElse(null);
    }
}
