package com.example.get.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer partientId;
    private String name;
    private Date dateOfBirth;


    @ManyToOne
    @JoinColumn(name ="admitted_by")
    private Employee admittedBy;

    public Patient(){}


}
