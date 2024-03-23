package com.lab402.demo.repository;

import com.lab402.demo.model.Employee;
import com.lab402.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //List<Employee> findAllEmployees();
    //ya existe!! findAll()

    List<Employee> findByStatus(Status status);

    List<Employee> findByDepartment(String department);
}
