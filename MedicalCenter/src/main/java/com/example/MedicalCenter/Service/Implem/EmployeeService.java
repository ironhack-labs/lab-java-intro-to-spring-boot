package com.example.MedicalCenter.Service.Implem;
import com.example.MedicalCenter.Model.EmployeeStatus;
import com.example.MedicalCenter.Model.Employee;
import com.example.MedicalCenter.Repository.EmployeeRepository;
import com.example.MedicalCenter.Service.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById (Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee" + id + "not found");
        return employeeOptional.get();
    }

    @Override
    public List<Employee> getEmployeesByStatus(EmployeeStatus status) {
        return employeeRepository.findByStatus(status);
    }

    @Override
    public List<Employee> getEmployeesByDepartment (String department) {
        return employeeRepository.findByDepartment(department);
    }


}