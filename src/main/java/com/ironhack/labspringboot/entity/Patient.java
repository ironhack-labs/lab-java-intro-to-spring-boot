package com.ironhack.labspringboot.entity;

import java.time.LocalDate;

public class Patient {

    private int patient_id;
    private String name;
    private LocalDate date_of_birth;
    private int addmitted_by;


    public Patient(int patient_id, String name, LocalDate date_of_birth, int addmitted_by) {
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.addmitted_by = addmitted_by;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
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

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getAddmitted_by() {
        return addmitted_by;
    }

    public void setAddmitted_by(int addmitted_by) {
        this.addmitted_by = addmitted_by;
    }
}
