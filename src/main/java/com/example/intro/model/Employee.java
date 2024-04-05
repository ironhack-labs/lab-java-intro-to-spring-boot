package com.example.intro.model;

import jakarta.persistence.*;
import lombok.Data;
import com.example.intro.model.utils.Status;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    Status status;
}
