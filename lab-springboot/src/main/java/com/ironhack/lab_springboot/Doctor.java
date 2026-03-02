package com.ironhack.lab_springboot;

public class Doctor {
    private int employee_id;
    private String department;
    private String name;
    private Status status;

    public Doctor(int employee_id, String department, String name, Status status) {
        this.employee_id = employee_id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getDepartment() {
        return department;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }


    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }
}
