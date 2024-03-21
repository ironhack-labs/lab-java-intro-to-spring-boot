package com.example.demo.Classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    private String department;
    private String name;
    private String status;

    public Employee() {
    }

    public Employee(Long employeeId, String department, String name, String status) {
        this.employee_id = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

}
