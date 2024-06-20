package com.ironhack.week_9_lab.repository;

import com.ironhack.week_9_lab.model.Employee;
import com.ironhack.week_9_lab.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Get all doctors: Create a route to get all doctors.
    //List<Employee> findAll();

    // Get doctor by ID: Create a route to get a doctor by employee_id.
    //List<Employee> findByEmployee_id(Integer employee_id);

    //Get doctors by status: Create a route to get doctors by status.
    List<Employee> findByStatus(EmployeeStatus status);

    //Get doctors by department: Create a route to get doctors by department.
    List<Employee> findByDepartment(String department);



}
