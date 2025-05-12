package com.ironhack.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ironhack.hospital.model.Employee;
import com.ironhack.hospital.model.Employee.Status;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(Status status);

    List<Employee> findByDepartment(String department);
}