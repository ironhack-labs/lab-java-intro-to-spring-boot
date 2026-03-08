package org.ironhack.collections.lab.Service;

import org.ironhack.collections.lab.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = List.of(
            new Employee(356712,"cardiology","Alonso Flores","ON_CALL"),
            new Employee(564134,"immunology","Sam Ortega","ON"),
            new Employee(761527,"cardiology","German Ruiz","OFF"),
            new Employee(166552,"pulmonary","Maria Lin","ON"),
            new Employee(156545,"orthopaedic","Paolo Rodriguez","ON_CALL"),
            new Employee(172456,"psychiatric","John Paul Armes","OFF")
    );

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getEmployeeId() == id).findFirst().orElse(null);
    }

    public List<Employee> getDoctorsByStatus(String status){
        return employees.stream()
                .filter(e -> e.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    public List<Employee> getDoctorsByDepartment(String department){
        return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase(department)).toList();
    }

}
