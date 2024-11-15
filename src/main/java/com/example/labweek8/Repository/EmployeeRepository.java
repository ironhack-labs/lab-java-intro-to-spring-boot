package com.example.labweek8.Repository;

import com.example.labweek8.Model.Employee;
import com.example.labweek8.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

    List<Employee> findEmployeeByStatus (Status status);
    List<Employee> findEmployeeByDepartment (String department);
}
