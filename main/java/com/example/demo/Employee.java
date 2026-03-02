package com.example.demo;

public class Employee {
  private long id;
  private String department;
  private String name;
  private String status;

    public long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Employee(long id, String department, String status, String name) {
        this.id = id;
        this.department = department;
        this.status = status;
        this.name = name;
    }
}
