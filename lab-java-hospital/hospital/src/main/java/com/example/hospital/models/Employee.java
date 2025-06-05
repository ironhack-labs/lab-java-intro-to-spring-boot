package com.example.hospital.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id
    private Long employeeId;

    private String department;

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
}
