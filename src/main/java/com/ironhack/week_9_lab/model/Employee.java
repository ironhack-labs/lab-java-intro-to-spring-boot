package com.ironhack.week_9_lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "admittedBy", fetch = FetchType.EAGER)
    private List<Patient> patient;

    public Employee(String department, String name, EmployeeStatus status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
