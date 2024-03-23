package com.ironhack.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.demo.model.Employee;
import com.ironhack.demo.enums.Department;
import com.ironhack.demo.enums.Status;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findAllByStatus(Status status);
    public List<Employee> findAllByDepartment(Department department);
}
