package com.ironhack.intro_to_spring_boot.entities;

import com.google.gson.annotations.SerializedName;
import com.ironhack.intro_to_spring_boot.enums.Status;
import tools.jackson.databind.annotation.JsonSerialize;


public class Employee {
    @JsonSerialize
    private Long employeeId;
    private String department;
    private String name;
    private Status status;

    public Employee(Long employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

public Long getEmployeeId() {
    return employeeId;
}public String getDepartment() {
    return department;
}public String getName() {
    return name;
}public Status getStatus() {
    return status;
}}
