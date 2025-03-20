package com.ironhack.lab401.repository;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
    List<Employee> findByDepartment(String department);
}
