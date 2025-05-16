package com.ironhack.Lab402IntroToSpringBoot202302.reporitory;

import com.ironhack.Lab402IntroToSpringBoot202302.model.Employee;
import com.ironhack.Lab402IntroToSpringBoot202302.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // here custom methods if I need them

    List<Employee> findAllByStatus(EmployeeStatus status);

    List<Employee> findAllByDepartment(String department);




}
