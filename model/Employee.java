package com.ironhack.week9lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "admitted_by",fetch = FetchType.EAGER)
    private List<Patient> patients;

    public Employee(String department, String name, EmployeeStatus status, List<Patient> patients) {
        this.department = department;
        this.name = name;
        this.status = status;
        this.patients = patients;
    }
}
