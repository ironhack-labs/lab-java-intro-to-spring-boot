package com.example.intro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate date_of_birth;
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admitted_by;
}
