package com.example.demo.Classes;

import jakarta.persistence.*;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    private String name;
    private Date date_of_birth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private Employee admitted_by;

    public Patient() {
    }
    public Patient(Long patientId, String name, java.sql.Date dateOfBirth, Employee admittedBy) {
        this.patient_id = patientId;
        this.name = name;
        this.date_of_birth = dateOfBirth;
        this.admitted_by = admittedBy;
    }

}
