package Lab2JavaSpringBoot.model;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data // ya me da getters y setters, constructor vacio y constructor lleno
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

}
