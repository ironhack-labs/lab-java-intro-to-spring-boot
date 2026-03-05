package org.ironhack.lab_spring1.controller;

import org.ironhack.lab_spring1.entity.Employee;
import org.ironhack.lab_spring1.entity.Patient;
import org.ironhack.lab_spring1.enums.EmployeeStatus;
import org.ironhack.lab_spring1.repository.EmployeeRepo;
import org.ironhack.lab_spring1.repository.PatientRepo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/aboutEmployees")
public class EmployeeController {
    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/getAll")
    public List<Employee> getEmpolyees() {
        return new ArrayList<>(employeeRepo.employees.values());
    }

    @GetMapping("/{id}")
    public Employee getEmpolyeeById(@PathVariable int id) {
        return employeeRepo.employees.get(id);

    }

    @GetMapping("status/{status}")
    public List<Employee> getEmpolyeeStatus(@PathVariable String status) {
        List<Employee> empolyeesList = new ArrayList<>();
        EmployeeStatus st= EmployeeStatus.valueOf(status.toUpperCase());
        for (Employee e : employeeRepo.employees.values()) {
            if (st.equals(e.getStatus())) {
                empolyeesList.add(e);
            }
        }
        return empolyeesList;
    }

    @GetMapping("department/{department}")
    public List<Employee> getEmpolyeeDepartment(@PathVariable String department) {
        List<Employee> empolyeesList = new ArrayList<>();
        for (Employee e : employeeRepo.employees.values()) {
            if (department.equals(e.getDepartment())) {
                empolyeesList.add(e);
            }
        }
        return empolyeesList;
    }


}
