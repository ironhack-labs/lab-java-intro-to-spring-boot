package com.ironhack.ironhack.model;

import java.time.LocalDate;

public class Patient {
    private long patient_id;
    private String name;
    private LocalDate date_of_birth;
    private long admitted_by;

    public Patient(long patient_id, String name, LocalDate date_of_birth, long admitted_by) {
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public long getAdmitted_by() {
        return admitted_by;
    }

    public void setAdmitted_by(long admitted_by) {
        this.admitted_by = admitted_by;
    }
}
