package com.ironhack.labspringboot9.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employeeId")
    private Employee admitted_by;

    public Patient(String name, Date dateOfBirth, Employee admitted_by) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admitted_by = admitted_by;
    }
}
