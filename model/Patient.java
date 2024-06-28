package com.ironhack.week9lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name="admitted_by")
    private Employee admittedBy;

    public Patient(String name, LocalDate dateOfBirth, Employee admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}
