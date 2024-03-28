package model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    public Employee(String department, String name, EmployeeStatus status) {
        setDepartment(department);
        setName(name);
        setStatus(status);
    }
}