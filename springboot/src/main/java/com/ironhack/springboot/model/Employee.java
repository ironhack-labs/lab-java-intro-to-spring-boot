package com.ironhack.springboot.model;

import com.ironhack.springboot.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    private String name;
    private String department;
    private EmployeeStatus status;

    //Note that admitted_by is a foreign key to the employee table.
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Patient> patients;


    public Employee(String name, String department, EmployeeStatus status) {
        this.name = name;
        this.department = department;
        this.status = status;
    }

}
