package com.springBoot.repository;

import com.springBoot.enums.StatusOfEmployee;
import com.springBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByStatus(StatusOfEmployee status);

    List<Employee> findByDepartment(String department);
}
