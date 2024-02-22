package com.example.drone.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "medication")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medication extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Pattern(regexp="^[a-zA-Z0-9-_]+$",message="Allowed only letters, numbers, ‘-‘, ‘_’")
    private String name;
    @Column(nullable = false)
    private double weight;
    @Pattern(regexp="^[A-Z0-9_]+$",message="allowed only upper case letters, underscore and numbers")
    private String code;
//    @Lob
//    @Column(name = "image", length = 1024000)
//    private byte[] image;
}
