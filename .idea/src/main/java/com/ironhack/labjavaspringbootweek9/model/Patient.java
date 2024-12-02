package com.ironhack.labjavaspringbootweek9.model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admitted_by",referencedColumnName = "id")
    private Employee admitted_by;

    public Patient(String name, LocalDate dateOfBirth, Employee admitted_by) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admitted_by = admitted_by;
    }
}
