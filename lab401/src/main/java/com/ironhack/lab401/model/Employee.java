package com.ironhack.lab401.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    private Integer employeeId;
    private String department;
    private String employeeName;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties(value = {"employee"}, allowSetters = true)
    List<Patient> patient = new ArrayList<>();

    public Employee() {
    }

    public Employee(Integer employeeId, String department, String employeeName, EmployeeStatus employeeStatus, List<Patient> patient) {
        this.employeeId = employeeId;
        this.department = department;
        this.employeeName = employeeName;
        this.employeeStatus = employeeStatus;
        this.patient = patient;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }
}