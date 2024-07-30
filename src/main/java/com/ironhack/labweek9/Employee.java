package com.ironhack.labweek9;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "admittedBy")
    private List<Patient> patients;

    // Getters and setters

}

enum Status {
    ON_CALL, ON, OFF
}


