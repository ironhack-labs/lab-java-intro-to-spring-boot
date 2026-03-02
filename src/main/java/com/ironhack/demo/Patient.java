package com.ironhack.demo;

import java.time.LocalDate;

public class Patient {
    final Long patient_id;
    final String name;
    final LocalDate dateOfBirth;
    final Long admitted_by;

    public Patient(Long patientId, String name, LocalDate dateOfBirth, Long admittedBy) {
        patient_id = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        admitted_by = admittedBy;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public long getAdmitted_by() {
        return admitted_by;
    }
}

