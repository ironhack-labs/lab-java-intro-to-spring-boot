package com.ironhack.labweek8.repository;

import com.ironhack.labweek8.model.Employee;
import com.ironhack.labweek8.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeeByStatus(EmployeeStatus employeeStatus);

    List<Employee> findEmployeeByDepartment(String department);
}
