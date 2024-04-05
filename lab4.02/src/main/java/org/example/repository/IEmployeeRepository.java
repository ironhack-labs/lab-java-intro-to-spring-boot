package org.example.repository;

import org.example.model.Employee;
import org.example.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findAll();
    Optional<Employee> findById(String id);
    Optional<List<Employee>> findByStatus(Status status);
    Optional<List<Employee>> findByDepartment(String department);
}
