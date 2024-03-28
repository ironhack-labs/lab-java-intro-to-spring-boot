package service;

import model.Employee;
import model.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findByEmployeeId(int employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public List<Employee> findAllByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }

    public List<Employee> findAllByStatus(EmployeeStatus status) {
        return employeeRepository.findAllByStatus(status);
    }

}