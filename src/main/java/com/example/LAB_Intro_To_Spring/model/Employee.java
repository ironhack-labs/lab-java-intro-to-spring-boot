package com.example.LAB_Intro_To_Spring.model;

public class Employee {
    private int employee_id;
    private String department;
    private String name;
    private String status;

    public Employee(int employee_id, String department, String name, String status) {
        this.employee_id = employee_id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployeeId() {
        return employee_id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
