package com.lab402.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;

    private String department;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "employee")
    private List<Patient> patients;

    public Employee(){}

    public Employee(Integer employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(department, employee.department) && Objects.equals(name, employee.name) && status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, department, name, status);
    }
}
