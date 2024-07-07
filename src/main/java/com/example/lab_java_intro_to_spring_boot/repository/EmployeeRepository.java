package com.example.lab_java_intro_to_spring_boot.repository;

import com.example.lab_java_intro_to_spring_boot.model.Employee;
import com.example.lab_java_intro_to_spring_boot.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findById(Integer id);
    List<Employee> findAllByDepartment(String department);
    List<Employee> findAllByName(String name);
    List<Employee> findAllByStatus(Status status);

}
