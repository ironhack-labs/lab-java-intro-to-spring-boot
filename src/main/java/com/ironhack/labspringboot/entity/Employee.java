package com.ironhack.labspringboot.entity;

import com.ironhack.labspringboot.enums.Status;

public class Employee {

    private int employee_id;
    private String department;
    private String name;
    private Status status;

    public Employee(int employee_id, String department, String name, Status status) {
        this.employee_id = employee_id;
        this.department = department;
        this.name = name;
        this.status = status;
    }


    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
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







