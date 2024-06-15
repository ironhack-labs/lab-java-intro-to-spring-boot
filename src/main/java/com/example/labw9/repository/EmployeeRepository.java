package com.example.labw9.repository;

import com.example.labw9.enums.Status;
import com.example.labw9.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);
}
