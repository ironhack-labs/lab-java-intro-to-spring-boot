package com.example.lab_java_intro_to_spring_boot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id

    private Integer id;
    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Employee(Integer id, String department, String name, Status status) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
