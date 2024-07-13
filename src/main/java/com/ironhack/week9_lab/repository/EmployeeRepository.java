package com.ironhack.week9_lab.repository;




import com.ironhack.week9_lab.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface EmployeeRepository<integer> extends JpaRepository<Employee, integer> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);


}
