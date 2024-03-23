package com.example.introjpa.demo.repository;

import com.example.introjpa.demo.model.Employee;
import com.example.introjpa.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
    Employee findByEmployeeId(Integer id);

    List<Employee> findAllByStatus(Status status);

    List<Employee> findAllByDepartment(String department);

}
