package week4Project1.Lab4._2.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week4Project1.Lab4._2.Models.Employee;
import week4Project1.Lab4._2.Repositories.EmployeeRepository;

import java.util.List;

@RestController
    @RequestMapping("/employees")
    public class EmployeeController {

        private final EmployeeRepository employeeRepository;

        public EmployeeController(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        @GetMapping("/{id}")
        public Employee getEmployeeById(@PathVariable Long id) {
            return employeeRepository.findById(id).orElse(null);
        }

        @GetMapping("/status/{status}")
        public List<Employee> getEmployeesByStatus(@PathVariable String status) {
            return employeeRepository.findByStatus(status);
        }

        @GetMapping("/department/{department}")
        public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
            return employeeRepository.findByDepartment(department);
        }
    }



