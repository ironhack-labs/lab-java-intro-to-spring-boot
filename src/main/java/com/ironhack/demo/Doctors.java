package com.ironhack.demo;

public class Doctors {
    final long employee_id;
    final String department;
    final String name;
    final Status status;

    public Doctors(long employeeId, String department, String name, Status status) {
        employee_id = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public String getDepartmentl() {
        return department;
    }

    public String getName() {
        return name;
    }
}
















