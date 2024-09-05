package com.intro.SpringBoot.repository;

import com.intro.SpringBoot.enums.StatusOfEmployee;
import com.intro.SpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByStatus(StatusOfEmployee status);

    List<Employee> findByDepartment(String department);
}
