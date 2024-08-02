package com.ironhack.multicityhospital2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    private Long employeeId;

    private String name;
    private String status;
    private String department;

    public Employee(Long employeeId, String name, String status, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.status = status;
        this.department = department;
    }

}