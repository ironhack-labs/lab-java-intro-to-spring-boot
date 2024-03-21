package com.example.demo.Repositories;

import com.example.demo.Classes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
