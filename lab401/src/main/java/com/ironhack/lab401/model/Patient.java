package com.ironhack.lab401.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;

    private LocalDate dateOfBirth;
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "admittedBy", referencedColumnName = "employeeId")
    private Employee employee;

    public Patient() {
    }

    public Patient(Integer patient_id, LocalDate dateOfBirth, String patientName, Employee employee) {
        this.patient_id = patient_id;
        this.dateOfBirth = dateOfBirth;
        this.patientName = patientName;
        this.employee = employee;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
