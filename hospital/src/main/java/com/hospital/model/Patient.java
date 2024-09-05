package com.hospital.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    private String name;

    private LocalDate dateOfBirth;

    // Relación Many-to-One con Employee
    @ManyToOne
    @JoinColumn(name = "admitted_by", nullable = false)
    private Employee admittedBy;
}
