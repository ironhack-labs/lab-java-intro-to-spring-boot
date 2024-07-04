package week4Project1.Lab4._2.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private long employeeId;
    private String department;
    private String name;
    private String status;


    //Getters and Setters
}
