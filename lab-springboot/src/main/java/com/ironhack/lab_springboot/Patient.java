package com.ironhack.lab_springboot;

import java.util.Date;

public class Patient {
    private int patient_id;
    private String name;
    private String date_of_birth;
    private int admitted_by;

    public Patient(String date_of_birth, int admitted_by, String name, int patient_id) {
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
        this.name = name;
        this.patient_id = patient_id;
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


    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setAdmitted_by(int admitted_by) {
        this.admitted_by = admitted_by;
    }

    public void setName(String name) {
        this.name = name;
    }
}
