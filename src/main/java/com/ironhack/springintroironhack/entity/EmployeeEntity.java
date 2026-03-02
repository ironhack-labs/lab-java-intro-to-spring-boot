package com.ironhack.springintroironhack.entity;

import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    public EmployeeEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
}
