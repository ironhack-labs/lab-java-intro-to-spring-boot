package com.example.LAB_Intro_To_Spring.model;

public class Patient {
private int patient_id;
private String name;
private String date_of_birth;
private int admitted_by;

    public Patient(int patient_id, String name, String date_of_birth, int admitted_by) {
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getName() {
        return name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public int getAdmitted_by() {
        return admitted_by;
    }
}
