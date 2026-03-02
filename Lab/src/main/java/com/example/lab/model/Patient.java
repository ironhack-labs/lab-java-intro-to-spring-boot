package com.example.lab.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Patient {
    @Id
    private long patientId;
    @Column
    private String name;
    @Column
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;
}
