package com.hospital.repository;

import com.hospital.enums.Department;
import com.hospital.enums.Status;
import com.hospital.model.Employee;
import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(Department department);
}
