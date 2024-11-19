package com.Hospital.lab.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository<Employee> extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
