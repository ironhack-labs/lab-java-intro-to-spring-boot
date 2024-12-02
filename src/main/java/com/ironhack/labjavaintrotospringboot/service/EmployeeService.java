package com.ironhack.labjavaintrotospringboot.service;

import com.ironhack.labjavaintrotospringboot.enums.StatusEnum;
import com.ironhack.labjavaintrotospringboot.model.Employee;
import com.ironhack.labjavaintrotospringboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void saveAll(List<Employee> employeeList) {
        log.info("saving all employees");
        employeeRepository.saveAll(employeeList);
    }

    public List<Employee> getAllDoctors() {
        log.info("getting all doctors");
        return employeeRepository.findAll();
    }

    public Optional<Employee> getDoctorByID(int employeeId) {
        log.info("getting doctor by ID: {}", employeeId);
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getDoctorsByStatus(StatusEnum status) {
        log.info("getting doctors by status: {}", status);
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getDoctorsByDepartment(String department) {
        log.info("getting doctors by department: {}", department.toLowerCase());
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }

}
