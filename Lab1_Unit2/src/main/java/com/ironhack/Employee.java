package com.ironhack;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
