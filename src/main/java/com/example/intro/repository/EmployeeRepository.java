package com.example.intro.repository;

import com.example.intro.model.Employee;
import com.example.intro.model.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(int id);
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);
}
