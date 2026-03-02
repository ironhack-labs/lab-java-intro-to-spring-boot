package org.example.springbootlab.entity;

import org.example.springbootlab.enums.EmployeeStatus;

public class Employee {
    private Integer employee_id;
    private String department;
    private String name;
    private EmployeeStatus status;

    public Employee(Integer employee_id, String department, String name, EmployeeStatus status) {
        this.employee_id = employee_id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public EmployeeStatus getStatus() {
        return status;
    }
}
