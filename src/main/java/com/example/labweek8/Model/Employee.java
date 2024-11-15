package com.example.labweek8.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table (name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String department;
    private String Name;

    @Enumerated (EnumType.STRING)
    private Status status;

    public Employee(int employeeId, String name, String department, Status status) {
        this.employeeId = (long) employeeId;
        Name = name;
        this.department = department;
        this.status = status;
    }

    @OneToMany
    @JoinColumn(name= "admittedBy")
    private List<Patient> patients;
}
