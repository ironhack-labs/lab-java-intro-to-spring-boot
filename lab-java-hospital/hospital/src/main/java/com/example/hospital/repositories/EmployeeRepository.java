package com.example.hospital.repositories;

import com.example.hospital.models.Employee;
import com.example.hospital.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee> findByDepartment(String department);
}
