package com.labs.lab402.repository;

import com.labs.lab402.model.Employee;
import com.labs.lab402.model.STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByStatus(STATUS status);
    List<Employee> findAllByDepartment(String department);
}
