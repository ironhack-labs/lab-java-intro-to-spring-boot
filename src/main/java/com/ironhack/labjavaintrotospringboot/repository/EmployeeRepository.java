package com.ironhack.labjavaintrotospringboot.repository;

import com.ironhack.labjavaintrotospringboot.enums.StatusEnum;
import com.ironhack.labjavaintrotospringboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByStatus(StatusEnum status);
    public List<Employee> findByDepartmentIgnoreCase(String department);
}
