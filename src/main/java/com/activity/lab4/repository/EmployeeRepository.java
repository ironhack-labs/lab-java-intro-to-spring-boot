package com.activity.lab4.repository;

import ch.qos.logback.core.status.Status;
import com.activity.lab4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);
}
