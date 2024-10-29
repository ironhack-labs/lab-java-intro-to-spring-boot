package org.example.springbootlab.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@NoArgsConstructor
@Data
@Table(name = "Doctor")



public class Doctor {

    @Id

    private Long employeeId;
    private String department;
    private String name;
    private String status;

    public Doctor(Long employeeId, String department, String name, String status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
