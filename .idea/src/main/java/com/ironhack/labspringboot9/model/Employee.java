package com.ironhack.labspringboot9.model;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;
import com.ironhack.labspringboot9.enums.Status;

import java.io.ObjectInputFilter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id

    private Long employeeid;
    private String name;
    private String department;
    @Enumerated
    private Status status;

    public Employee(Long employeeid, Status status, String departament, String name) {
        this.employeeid = employeeid;
        this.name = name;
        this.department = departament;
        this.status = status;
    }
}
