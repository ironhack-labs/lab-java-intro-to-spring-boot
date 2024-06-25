package com.ironhack.week9_lab.model;

import com.ironhack.week9_lab.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "admittedBy", fetch = FetchType.EAGER)
    private List<Patient> patients;

    public Employee(String department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
