package com.example.drone.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicationDao {

    private String name;
    private double weight;
    private String code;

}
