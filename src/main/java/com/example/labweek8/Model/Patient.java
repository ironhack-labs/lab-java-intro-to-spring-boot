package com.example.labweek8.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table (name="patient")

public class Patient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long patientId;

    private String PatientName;
    private Integer dateOfBirth;
    private int admittedBy;



    @OneToOne
    @JoinColumn(name = "admitted_by") // in the database you will have a column with just the id of the employee connected
    private Employee doctor;

    public Patient(String patientName, Integer dateOfBirth, int admittedBy) {
        PatientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}
