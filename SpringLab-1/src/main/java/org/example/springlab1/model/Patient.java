package org.example.springlab1.model;

import java.time.LocalDate;

public class Patient {
    private Long patientId;
    private String name;
    private LocalDate dateOfBirth;
    private Long admittedBy;

    public Patient(){}

    public Patient(Long patientId, String name, LocalDate dateOfBirth, Long admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getName() { return name; }


    public void setName(String name) { this.name = name; }


    public LocalDate getDateOfBirth() { return dateOfBirth; }


    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }


    public Long getAdmittedBy() { return admittedBy; }
    public void setAdmittedBy(Long admittedBy) { this.admittedBy = admittedBy; }
}


