package com.ironhack.week9_lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate dateOfBbirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;

    public Patient(String name, LocalDate dateOfBbirth, Employee admittedBy) {
        this.name = name;
        this.dateOfBbirth = dateOfBbirth;
        this.admittedBy = admittedBy;
    }

    public Patient(String jaimeJordan, LocalDate of, String employee1) {


    }
}





