package com.ironhack.labjavaintrotospringboot.model.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "patients")
@NoArgsConstructor
public class Patient extends User {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Doctor doctor;

    public Patient(Date dateOfBirth, Doctor doctor) {
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
    }
}
