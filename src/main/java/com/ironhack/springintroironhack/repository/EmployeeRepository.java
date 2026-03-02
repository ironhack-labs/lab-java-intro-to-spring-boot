package com.ironhack.springintroironhack.repository;

import com.ironhack.springintroironhack.entity.EmployeeEntity;
import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByStatus(EmployeeStatus status);

    List<EmployeeEntity> findByDepartment(Department department);
}
