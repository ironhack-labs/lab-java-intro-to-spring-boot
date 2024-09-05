package com.lab_java_intro_to_spring_boot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admittedBy")
    Employee admittedBy;
}
