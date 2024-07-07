package com.ironhack.lab_java_intro_to_spring_boot.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String department;
    private String name;
    private String status;

    @OneToMany(mappedBy = "admittedBy")
    private List<Patient> patients;

    // Constructors, getters, and setters
}
