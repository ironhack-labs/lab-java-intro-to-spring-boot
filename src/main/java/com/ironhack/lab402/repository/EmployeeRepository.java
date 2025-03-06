package com.ironhack.lab402.repository;

import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByStatus(Status status);

    List<Employee> findAllByDepartment(String department);

}
