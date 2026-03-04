package org.example.spring_boot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long employee_id;
    private String department;
    private String name;
    private String status;
    public Employee(){}
    public Employee(Long employee_id, String department, String name,String status){
        this.employee_id=employee_id;
        this.department=department;
        this.name=name;
        this.status=status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }
}
