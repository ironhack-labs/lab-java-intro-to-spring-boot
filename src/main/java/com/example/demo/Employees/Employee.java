package com.example.demo.Employees;

public class Employee {

    private String id;
    private String department;
    private String name;
    private EmployeeStatus status;

    public Employee(String id, EmployeeStatus status, String name, String department) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

