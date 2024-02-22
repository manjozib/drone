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
    @Column(name = "id")
    private Long id;
    @Column(name = "drone_serial_number")
    private String droneSerialNumber;
    @Column(name = "medical_code")
    private String medicalCode;
    @Column(name = "quantity_of_medication")
    private int quantityOfMedication;

}
