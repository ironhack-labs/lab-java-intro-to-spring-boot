package com.example.labweek8.Service;

import com.example.labweek8.Model.Employee;
import com.example.labweek8.Model.Status;
import com.example.labweek8.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
        }

        public List<Employee> findAll(){
        return employeeRepository.findAll();
        }
        public Optional<Employee> findByID(Long id) {
        return employeeRepository.findById(id);

        public List <Employee> getEmployeeByStatus; {
            return employeeRepository.findEmployeeByStatus(status);
            }

            public List <Employee> findByDepartment (String department){
            return employeeRepository.findEmployeeByDepartment(department);
            }

            public List<Employee> getEmployeeByStatusOff (String status){
            return employeeRepository.findEmployeeByStatus(Status.OFF)
            }


            }


    public List<Employee> getAllEmployees() {
    }
}
    }

