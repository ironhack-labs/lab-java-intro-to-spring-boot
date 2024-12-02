package com.ironhack.labjavaspringbootweek9.model;

import com.ironhack.labjavaspringbootweek9.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

@Table(name = "doctors")
public class Employee {
    @Id
    private Long id;
    private String name;
    private String department;
    @Enumerated
    private Status status;

    public Employee(Long employeeId, String name, String department, Status status) {
        this.id = employeeId;
        this.name = name;
        this.department = department;
        this.status = status;
    }
}



