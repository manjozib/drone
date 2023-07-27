package com.example.drone.controller;


import com.example.drone.dao.MedicationDao;
import com.example.drone.model.Medication;
import com.example.drone.service.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    @Autowired
    MedicationServiceImpl medicationServiceImpl;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMedication(@RequestParam("image")MultipartFile image,
                                   @RequestParam("code") String  code,
                                   @RequestParam("name") String name,
                                   @RequestParam("weight") double weight) throws IOException {
        Medication medication = new Medication();
        medication.setName(name);
        medication.setCode(code);
        medication.setWeight(weight);
        medication.setImage(image.getBytes());
        return medicationServiceImpl.loadMedication(medication);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllMedications() {

        List<Medication> medicationList = medicationServiceImpl.getAllMedications();
        List<MedicationDao> medicationDaoList = new ArrayList<>();

        for (Medication medication : medicationList) {
            medicationDaoList.add(new MedicationDao(
                    medication.getName(),
                    medication.getWeight(),
                    medication.getCode()
            ));
        }

        return medicationDaoList.size() > 0 ? new ResponseEntity<>(medicationDaoList, HttpStatus.OK)
                : new ResponseEntity<>("No Medication", HttpStatus.NOT_FOUND);
    }


}
