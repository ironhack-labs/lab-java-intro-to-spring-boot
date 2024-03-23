package com.lab402.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String name;
    private LocalDate dateOfBirth;

    //private Integer admittedBy;
    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private Employee employee;

    public Patient (){}

    public Patient(String name, LocalDate dateOfBirth, Employee employee) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) && Objects.equals(name, patient.name) && Objects.equals(dateOfBirth, patient.dateOfBirth)  && Objects.equals(employee, patient.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, name, dateOfBirth, employee);
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public Integer getAdmittedBy() {
//        return admittedBy;
//    }
//
//    public void setAdmittedBy(Integer admittedBy) {
//        this.admittedBy = admittedBy;
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
