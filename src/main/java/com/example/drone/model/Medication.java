package com.example.drone.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Entity
@Table(name = "medication")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medication {

    @Pattern(regexp="^[a-zA-Z0-9-_]+$",message="allowed only letters, numbers, ‘-‘, ‘_’")
    private String name;
    private double weight;
    @Id
    @Pattern(regexp="^[A-Z0-9_]+$",message="allowed only upper case letters, underscore and numbers")
    private String code;
    @Lob
    @Column(name = "image", length = 1024000)
    private byte[] image;
}
