package ironhack.com.lab9.service;

import ironhack.com.lab9.model.Employee;
import ironhack.com.lab9.repository.EmployeeRepository;
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

    public List<Employee> findAll() {
        log.info("Listing all employees");
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long employeeId) {
        log.info("Listing an employee with id: {}",employeeId );
        return employeeRepository.findById(employeeId);

    }

    public List<Employee> findAllByStatus(String status) {
        log.info("Listing all employees with status: {}", status);
        return employeeRepository.findAllByStatusIgnoreCase(status);
    }

    public List<Employee> findAllByDepartment(String department) {
        log.info("Listing all employees with department: {}", department);
        return employeeRepository.findAllByDepartmentIgnoreCase(department);
    }

    public Employee addEmployee(Employee employee){
        log.info("Adding new employee{}", employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee employee){
        log.info("Updating employee with id{}", employeeId);
        var employeeToUpdate = employeeRepository.findById(employeeId).orElseThrow();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setDepartment(employee.getDepartment());
        employeeToUpdate.setStatus(employee.getStatus());
//        employeeToUpdate.setPatients(employee.getPatients());

        return  employeeRepository.save(employeeToUpdate);
    }




}
