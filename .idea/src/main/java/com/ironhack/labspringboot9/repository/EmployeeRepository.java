package com.ironhack.labspringboot9.repository;

import com.ironhack.labspringboot9.enums.Status;
import com.ironhack.labspringboot9.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);
}
