package com.example.lab.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    private Long employeeId;
    @Column
    private String department;
    @Column
    private String name;
    @Column
    private String status;
}