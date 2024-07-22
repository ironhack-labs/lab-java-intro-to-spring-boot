// src/main/java/com/renereyes/sql/hospitalmanagement/repository/EmployeeRepository.java
package com.renereyes.sql.hospitalmanagement.repository;

import com.renereyes.sql.hospitalmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
