package com.ironhack.labjavaintrotospringboot.model;

import com.ironhack.labjavaintrotospringboot.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee Table")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int id;

    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

}
