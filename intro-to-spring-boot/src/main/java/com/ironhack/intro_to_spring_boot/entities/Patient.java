package com.ironhack.intro_to_spring_boot.entities;



import tools.jackson.databind.annotation.JsonSerialize;
public class Patient {
    @JsonSerialize
    private Long patientId;
    private String name;
    @JsonSerialize
    private String dateOfBirth;
    @JsonSerialize
    private Long admittedBy;

    public Patient(Long patientId, String name, String dateOfBirth, Long admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public Long getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public Long getAdmittedBy() {
        return admittedBy;
    }
}
