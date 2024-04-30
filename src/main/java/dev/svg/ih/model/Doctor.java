package dev.svg.ih.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Employee")
public class Doctor {

    @Id
    @Column(name = "employee_id")
    private int doctorId;
    private String department;
    private String name;
    private String status;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    public Doctor() {}

    public Doctor(int doctorId, String department, String name, String status) {
        this.doctorId = doctorId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}