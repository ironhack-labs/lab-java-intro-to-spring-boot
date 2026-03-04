package org.example.spring_boot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    private Long patient_id;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;
    public Patient(){}
    public Patient(Long patient_id,String name, LocalDate dateOfBirth){
        this.patient_id=patient_id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
    }
    public String getName(){
        return this.name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
    public Long getPatient_id(){
        return this.patient_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public void setAdmitted_by(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
