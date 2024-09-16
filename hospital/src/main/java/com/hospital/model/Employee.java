package com.hospital.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    private Long employeeId;
    private String department;
    private String name;
    private String status;
}
