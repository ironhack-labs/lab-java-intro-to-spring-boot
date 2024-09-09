package Lab2JavaSpringBoot.service;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import Lab2JavaSpringBoot.model.Employee;
import Lab2JavaSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> searchByEmployeeStatus (EmployeeStatus doctorStatus){
        return employeeRepository.findByEmployeeStatus(doctorStatus);
    }

    public List<Employee> searchDoctorDepartment(String department){
        return employeeRepository.findByDepartment(department);
    }
}