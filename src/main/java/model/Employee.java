package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;
    @Setter
    @Getter
    private String department;
    private String Name;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Status status;
@OneToMany(mappedBy = "employee")
private List<Patient> patients;
    public Employee(String name){
        this.name = name;
    }

    public Employee(Integer employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Employee() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(department, employee.department) && Objects.equals(name, employee.name) && status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, department, name, status);
    }
}
