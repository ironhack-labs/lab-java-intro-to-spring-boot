package com.ironhack.springintroironhack.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private Long admitted_by;

    public PatientEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getAdmitted_by() {
        return admitted_by;
    }

    public void setAdmitted_by(Long admitted_by) {
        this.admitted_by = admitted_by;
    }
}
