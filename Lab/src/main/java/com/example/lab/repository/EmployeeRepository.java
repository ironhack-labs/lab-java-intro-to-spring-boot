package com.example.lab.repository;

import com.example.lab.model.Employee;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Optional<List<Employee>>findByStatus(String status);

    Optional<List<Employee>> findByDepartment(String department);
}
