package com.lab_java_intro_to_spring_boot.repository;

import com.lab_java_intro_to_spring_boot.Enums.EmployeeDepartment;
import com.lab_java_intro_to_spring_boot.Enums.EmployeeStatus;
import com.lab_java_intro_to_spring_boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee> findByDepartment(EmployeeDepartment department);

}
