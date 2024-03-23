package com.hospital.hospitalmanagment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="patient")
public class Patient {
    @Id
    private int patientId;

    private String name;
    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;
}
