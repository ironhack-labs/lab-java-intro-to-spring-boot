package com.renereyes.sql.hospitalmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long employeeId;
    private String department;
    private String name;
    private String status;

    // Getters and Setters
}
