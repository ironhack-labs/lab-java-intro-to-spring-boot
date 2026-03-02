package com.ironhack.springboottask.Entity;

import com.ironhack.springboottask.enums.Status;

public class Employee {
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

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }
}
