package com.ironhack.ironhack.model;

import com.ironhack.ironhack.Enums.Status;

import java.lang.ref.PhantomReference;

public class Employee {
    private long employee_id;
    private String department;
    private String name;
    private Status status;

    public Employee(long employee_id, String department, String name, Status status) {
        this.employee_id = employee_id;
        this.department = department;
        this.name = name;
        this.status = Status.OFF;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
