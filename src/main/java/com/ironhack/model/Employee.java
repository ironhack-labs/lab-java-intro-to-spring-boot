package com.ironhack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    private Integer employee_id;
    private String department;
    private String name;
    private String status;

    public enum Status {
        ON,
        OFF,
        ON_CALL
    }

}
