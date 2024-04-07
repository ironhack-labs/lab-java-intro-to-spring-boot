package com.ironhack.repository;

import com.ironhack.model.Employee;
import com.ironhack.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();
    Optional<Employee> findByEmployeeId(int employeeId);
    List<Employee> findAllByStatus(Status status);
    List<Employee> findAllByDepartment(String department);
}
