package com.ironhack.labjavaintrotospringboot.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "doctors")
@NoArgsConstructor
public class Doctor extends User {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private DoctorStatus status;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Patient> patients;

    public Doctor(int doctorId, Department department, DoctorStatus status) {
        this.doctorId = doctorId;
        this.department = department;
        this.status = status;
    }
}
