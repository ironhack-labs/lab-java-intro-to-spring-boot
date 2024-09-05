package com.lab_java_intro_to_spring_boot.model;

import com.lab_java_intro_to_spring_boot.Enums.EmployeeDepartment;
import com.lab_java_intro_to_spring_boot.Enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    Integer id;
    @Enumerated(EnumType.STRING)
    EmployeeDepartment department;
    String name;
    @Enumerated(EnumType.STRING)
    EmployeeStatus status;

}
