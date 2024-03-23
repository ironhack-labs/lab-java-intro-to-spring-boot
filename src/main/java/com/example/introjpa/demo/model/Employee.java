package com.example.introjpa.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @OneToMany
    private List<Patient> patientList= new ArrayList<Patient>();

    @Column(name = "department")
    private String department;

    @Column(name = "employee_name")
    private String Name;

    @Column(name = "status")
    private Status status;

    public Employee( String department, String name, Status status) {
        setDepartment(department);
        setName(name);
        setStatus(status);
    }

    public Employee(){}

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployee_id(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
