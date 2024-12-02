package com.ironhack.labjavaspringbootweek9.repository;

import com.ironhack.labjavaspringbootweek9.enums.Status;
import com.ironhack.labjavaspringbootweek9.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(Status status);

    List<Employee> findByDepartment(String department);

}
