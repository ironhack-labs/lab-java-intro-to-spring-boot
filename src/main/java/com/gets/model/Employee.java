package com.gets.model;

import com.gets.Enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private int employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
}
