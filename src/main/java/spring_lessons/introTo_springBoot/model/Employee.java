package spring_lessons.introTo_springBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Integer employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

}
