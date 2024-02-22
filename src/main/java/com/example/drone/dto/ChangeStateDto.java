package com.example.drone.dto;

import com.example.drone.enums.State;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ChangeStateDto {
    @Size(max = 10, message = "Serial number cannot exceed 100 characters")
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "Serial number cannot be blank")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Invalid state")
    private State state;

}
