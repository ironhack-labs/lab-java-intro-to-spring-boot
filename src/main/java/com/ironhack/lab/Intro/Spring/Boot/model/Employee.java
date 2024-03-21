package com.ironhack.lab.Intro.Spring.Boot.model;

import com.ironhack.lab.Intro.Spring.Boot.Enum.Department;
import com.ironhack.lab.Intro.Spring.Boot.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private long employeeId;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

}
