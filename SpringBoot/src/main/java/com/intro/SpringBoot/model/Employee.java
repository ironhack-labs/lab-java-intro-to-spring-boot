package com.intro.SpringBoot.model;

import com.intro.SpringBoot.enums.StatusOfEmployee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    private Integer employeeId;

    private String department;
    private String name;
    private StatusOfEmployee status;
}
