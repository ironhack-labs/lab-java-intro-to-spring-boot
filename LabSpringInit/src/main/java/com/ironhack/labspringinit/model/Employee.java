package com.ironhack.labspringinit.model;

public class Employee {
    private int employeeId;
    private String department;
    private String name;
    private String status;

    public Employee(int employeeId, String department, String name, String status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public String getName() { return name; }
    public String getStatus() { return status; }
}
