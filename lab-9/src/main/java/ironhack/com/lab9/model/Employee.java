package ironhack.com.lab9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String department;
    private String name;
    private String status;

//    @OneToMany(mappedBy = "employee")
//    @JsonIgnore
//    private List<Patient> patients;

    public Employee(String department, String name, String status){
        this.department = department;
        this.name = name;
        this.status = status;
    }


}
