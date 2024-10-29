package org.example.springbootlab.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {


    @Id
    private Long patientId;
    private String name;
    private String dateOfBirth;

    @ManyToOne
    private Doctor admittedBy;

    public Patient(Long patientId, String name, String dateOfBirth, Doctor admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}