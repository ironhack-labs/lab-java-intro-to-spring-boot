package com.springBoot.model;


import com.springBoot.enums.StatusOfEmployee;
import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Id;

@Data
@Entity
public class Employee {

    @Id
    private Integer employeeId;

    private String department;
    private String name;
    private StatusOfEmployee status;
}
