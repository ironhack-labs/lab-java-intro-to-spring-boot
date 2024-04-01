package com.example.Spring.model;

import com.example.Spring.EmployeeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    private String name;
    private EmployeeStatus status;
    @OneToMany(mappedBy = "admittedBy")
    private Set<Patient> patients;

    public Employee(String department, String name, EmployeeStatus status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
