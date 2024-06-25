package com.ironhack.week9_lab.repository;

import com.ironhack.week9_lab.enums.Status;
import com.ironhack.week9_lab.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

List<Employee> findByStatus(Status status);
List<Employee> findByDepartment(String department);

}
