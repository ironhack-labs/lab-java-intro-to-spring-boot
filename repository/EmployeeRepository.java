package com.ironhack.week9lab.repository;

import com.ironhack.week9lab.model.Employee;
import com.ironhack.week9lab.model.EmployeeStatus;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee>findByStatus(EmployeeStatus status);
    List<Employee>findByDepartment(String department );

}
