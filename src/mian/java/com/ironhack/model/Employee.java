package com.ironhack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Long employeeId;
    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Employee() {}
    public Employee(Long employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Long getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public String getName() { return name; }
    public Status getStatus() { return status; }
}