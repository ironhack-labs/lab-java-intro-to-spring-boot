package com.ironhack.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;
    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private Employee admittedBy;

    public Patient(String name, LocalDate date_of_birth, Employee admittedBy) {
        this.name = name;
        this.dateOfBirth = date_of_birth;
        this.admittedBy = admittedBy;
    }

}


