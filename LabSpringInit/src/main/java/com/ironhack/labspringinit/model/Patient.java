package com.ironhack.labspringinit.model;

import java.time.LocalDate;

public class Patient {

    private int patientId;
    private String name;
    private String dateOfBirth;
    private int admittedBy;

    public Patient(int patientId, String name, String dateOfBirth, int admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getDateOfBirth() { return dateOfBirth; }
    public int getAdmittedBy() { return admittedBy; }
}

