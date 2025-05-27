package com.example.MedicalCenter.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private Long id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(Long id, String department, String name, EmployeeStatus status) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
