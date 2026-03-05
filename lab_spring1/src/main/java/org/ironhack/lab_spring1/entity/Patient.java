package org.ironhack.lab_spring1.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
public class Patient {
    private int patientId;
    private String name;
    private LocalDate dateOfBirth;
    private int admittedBy;

    public Patient(int patientId, String name, LocalDate dateOfBirth, int admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }




}
