package com.example.drone.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medication")
@AllArgsConstructor
@NoArgsConstructor
public class Medication {
    private String name;
    private double weight;
    private String code;
    private byte[] image;
}
