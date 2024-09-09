package Lab2JavaSpringBoot.controller;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import Lab2JavaSpringBoot.model.Employee;
import Lab2JavaSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){ return employeeService.getAllEmployees();}

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employees = employeeService.getEmployeeById(id);
        return employees.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/doctors-status")
    public ResponseEntity<List<Employee>> searchEmployeeStatus (@RequestParam EmployeeStatus doctorStatus){
        List<Employee> employees = employeeService.searchByEmployeeStatus(doctorStatus);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/search/doctor-department")
    public ResponseEntity<List<Employee>> searchDoctorDepartment(@RequestParam String department){
        List<Employee> employees = employeeService.searchDoctorDepartment(department);
        return ResponseEntity.ok(employees);
    }
}