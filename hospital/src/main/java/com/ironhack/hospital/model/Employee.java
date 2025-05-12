package com.ironhack.hospital.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer employee_id;
    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "admittedBy")
    @JsonManagedReference
    private List<Patient> patients;

    public enum Status {
        ON_CALL, ON, OFF
    }
}
