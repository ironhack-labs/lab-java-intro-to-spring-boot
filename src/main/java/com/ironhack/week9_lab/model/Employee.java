package com.ironhack.week9_lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@Table(name = "employees")
@ToString
public class Employee  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "admittedBy", fetch = FetchType.EAGER)
    private List<Patient> patients;

    public Employee(String department, String name, EmployeeStatus status,List<Patient> patients) {
        this.department = department;
        this.name = name;
        this.status = status;
        this.patients = patients;
    }


    public Employee() {

    }

    public Employee(String cardiology, String germanRuiz, EmployeeStatus employeeStatus) {


    }
}


