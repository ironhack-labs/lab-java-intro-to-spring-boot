package com.ironhack.model;

import com.ironhack.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    private int employeeId;
    private String department;
    private String name;
    private Status status;

    public Employee(int employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }
}