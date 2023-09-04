package com.example.drone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "load")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String droneSerialNumber;
    private String medicalCode;
    private int quantityOfMedication;
    private double totalWeight;

}
