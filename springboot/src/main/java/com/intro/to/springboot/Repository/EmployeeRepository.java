package com.intro.to.springboot.Repository;

import com.intro.to.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
