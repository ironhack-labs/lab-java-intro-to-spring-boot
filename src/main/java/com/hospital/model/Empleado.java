package com.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Empleado {
    @Id
    private Long empleadoId;
    private String department;
    private String name;
    private String status;
}
