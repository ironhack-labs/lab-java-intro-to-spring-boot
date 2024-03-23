package com.ironhack.demo.repository;

import com.ironhack.demo.model.Employee;
import com.ironhack.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findAll();
    Optional<Employee> findById(String id);
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);

}
