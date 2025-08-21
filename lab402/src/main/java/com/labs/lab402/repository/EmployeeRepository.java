package com.labs.lab402.repository;

import com.labs.lab402.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatusIn(List<String> statuses);

    Optional<Employee> findByEmployeeIdAndStatusIn(Long employeeId, List<String> statuses);

    List<Employee> findByStatus(String status);

    List<Employee> findByDepartment(String department);

    List<Employee> findByDepartmentAndStatusIn(String department, List<String> statuses);
}
