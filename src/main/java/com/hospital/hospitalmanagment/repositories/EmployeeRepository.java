package com.hospital.hospitalmanagment.repositories;

import com.hospital.hospitalmanagment.model.Employee;
import com.hospital.hospitalmanagment.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);

}
