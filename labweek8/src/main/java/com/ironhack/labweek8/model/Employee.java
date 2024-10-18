package com.ironhack.labweek8.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer id;

    private String name;

    private String department;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
}