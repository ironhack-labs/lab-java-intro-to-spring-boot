package com.example.Lab402.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private String name;

    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Doctor admittedBy;

    public Patient() {
    }

    public Patient(String name, Date dateOfBirth, Doctor admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Doctor admittedBy) {
        this.admittedBy = admittedBy;
    }
}
