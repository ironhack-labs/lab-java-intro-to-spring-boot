package org.example.springbootlab.entity;

import java.time.LocalDate;

public class Patient {
    private Integer patient_id;
    private String name;
    private LocalDate date_of_birth;
    private Integer admitted_by;

    public Patient(Integer patient_id, String name, LocalDate date_of_birth, Integer admitted_by) {
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public Integer getAdmitted_by() {
        return admitted_by;
    }

}
