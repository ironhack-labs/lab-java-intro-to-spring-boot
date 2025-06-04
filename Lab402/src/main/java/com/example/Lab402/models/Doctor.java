package com.example.Lab402.models;

import com.example.Lab402.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    private String employeeId;

    private String department;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "admittedBy")
    @JsonIgnore
    private List<Patient> patients;

    public Doctor() {
    }

    public Doctor(String employeeId, String department, String name, EmployeeStatus status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
