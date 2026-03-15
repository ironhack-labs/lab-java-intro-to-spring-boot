package com.example.lab_java_intro_to_spring_boot.model;

public class Employee {
    private Integer id;
    private String department;
    private String name;
    private Status status;

    public Employee(Integer id, String department, String name, Status status) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Employee() { }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}