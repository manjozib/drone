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
    @Column(nullable = false, name = "id")
    private String id;
    private String name;
    @Column(nullable = false, name = "weight")
    private double weight;
    @Column(nullable = false, name = "code")
    private String code;
//    @Lob
//    @Column(name = "image", length = 1024000)
//    private byte[] image;
}
