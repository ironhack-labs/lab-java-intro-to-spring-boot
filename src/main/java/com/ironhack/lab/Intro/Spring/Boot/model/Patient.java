package com.ironhack.lab.Intro.Spring.Boot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employeeId")
    private Employee admittedBy;
}
