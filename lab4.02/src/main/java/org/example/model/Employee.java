package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
     @Id
     @Column(name = "employee_id")
     private String id;
     private String department;
     private String name;
     @Enumerated(EnumType.STRING)
     private Status status;
     public Employee(){}

     public Employee(String employeeId, String department, String name, Status status) {
         setId(employeeId);
         setDepartment(department);
         setName(name);
         setStatus(status);
     }

     public String getId() {
         return this.id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getDepartment() {
         return this.department;
     }

     public void setDepartment(String department) {
         this.department = department;
     }

     public String getName() {
         return this.name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Status getStatus() {
         return this.status;
     }

     public void setStatus(Status status) {
         this.status = status;
     }

}
