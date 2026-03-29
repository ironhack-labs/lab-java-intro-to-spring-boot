package com.ironhack.spring.model;

import com.ironhack.spring.Enums.Status;

public class Employee {
    private long employee_id;
    private String department;
    private String name;
    private Status status;

    public Employee(long id, String department,  String name, Status status) {
        this.department = department;
        this.employee_id = employee_id;
        this.name = name;
        this.status = status.OFF;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getId() {
        return employee_id;
    }

    public void setId(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
