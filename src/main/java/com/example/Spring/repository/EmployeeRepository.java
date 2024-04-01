package com.example.Spring.repository;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Optional<Employee> findByEmployeeId(int employeeId);

    List<Employee> findByStatus(Optional<EmployeeStatus> status);

    List<Employee> findAllByDepartment(Optional<String> department);
}
