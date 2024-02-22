package com.example.drone.service.impl;

import com.example.drone.dto.LoadLinesDto;
import com.example.drone.dto.LoadMedicationDto;
import com.example.drone.model.Drone;
import com.example.drone.model.LoadLines;
import com.example.drone.model.Medication;
import com.example.drone.repository.LoadLinesRepository;
import com.example.drone.service.LoadLinesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoadLinesServiceImpl implements LoadLinesService {

    private final DroneServiceImpl droneService;

    private final LoadLinesRepository loadLinesRepository;
    private final MedicationServiceImpl medicationService;

    public LoadLinesServiceImpl(DroneServiceImpl droneService,
                                LoadLinesRepository loadLinesRepository,
                                MedicationServiceImpl medicationService) {
        this.droneService = droneService;
        this.loadLinesRepository = loadLinesRepository;
        this.medicationService = medicationService;
    }

    @Override
    public void loadMedication(LoadLinesDto loadLinesDto) {
        Drone find = droneService.searchDroneExistence(loadLinesDto.getDroneSerialNumber());
        //Map<String, Object> map = new HashMap<>();
        if (find != null) {
            List<LoadLines> loadLinesList = new ArrayList<>();
            for (LoadMedicationDto loadMedicationDto: loadLinesDto.getLoadMedicationDtoList()) {
                Medication medication = medicationService.searchExistenseByCode(loadMedicationDto.getMedicalCode());
                if (medication == null) {
                    System.out.println("Medication not found");
                    continue;
                }
                loadLinesList.add(new LoadLines(
                       0L, find.getSerialNumber(),
                        loadMedicationDto.getMedicalCode(),
                        loadMedicationDto.getQuantityOfMedication()
                ));
            }
            loadLinesRepository.saveAll(loadLinesList);
        } else {
            throw new RuntimeException("Drone of serial#:" + loadLinesDto.getDroneSerialNumber() + " does not exist");
        }
    }
}
