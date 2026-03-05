package org.ironhack.lab_spring1.entity;

import lombok.Getter;
import lombok.Setter;
import org.ironhack.lab_spring1.enums.EmployeeStatus;

@Getter
@Setter
public class Employee {
    private int id;
    private String department;
    private String name;
    private EmployeeStatus status;

    public Employee(int id, String department, String name, EmployeeStatus status) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.status = status;
    }


}
