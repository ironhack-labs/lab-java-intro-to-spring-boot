package com.IntroToSpring.Lab402IntroToSpringBoot.repository;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
