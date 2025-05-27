package com.example.MedicalCenter.Repository;

import com.example.MedicalCenter.Model.Employee;
import com.example.MedicalCenter.Model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee> findByDepartment (String department);


}
