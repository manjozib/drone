package com.example.drone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "load_lines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadLines extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String droneSerialNumber;
    private String medicalCode;
    private int quantityOfMedication;

}
