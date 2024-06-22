package com.ironhack.springboot.repository;

import com.ironhack.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    Get all doctors: Create a route to get all doctors.
//    Get doctor by ID: Create a route to get a doctor by employee_id.
//    Get doctors by status: Create a route to get doctors by status.
//    Get doctors by department: Create a route to get doctors by department.

    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByStatus(String status);
    List<Employee> getEmployeesByDepartment(String department);

}
