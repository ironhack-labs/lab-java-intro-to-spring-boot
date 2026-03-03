package az.lab.intro.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.lab.intro.entity.Employee;
import az.lab.intro.entity.EmployeeEntity;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {

    Employee employees = new Employee();


    //1. Get all doctors: Create a route to get all doctors.
    @GetMapping("all-doctors")
    public List<Map.Entry<Integer, EmployeeEntity>> getAllEmployees() {

        return new ArrayList<>(employees.employees.entrySet());
    }

    //2. Get doctor by ID: Create a route to get a doctor by employee_id.
    @GetMapping("get-by-id/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable int id){


        return employees.getEmployees().get(id);
    }

    //3. Get doctors by status: Create a route to get doctors by status.
    @GetMapping("get-by-status/{status}")
    public List<Map<Integer, EmployeeEntity>> getByStatus(@PathVariable String status){

        List<Map<Integer, EmployeeEntity>> filtered = new ArrayList<>();

        employees.getEmployees().forEach((id, employee) -> {

                    if(employee.getStatus().equalsIgnoreCase(status)){
                        Map<Integer, EmployeeEntity> map = new HashMap<>();
                        map.put(id, employee);
                        filtered.add(map);
                    }
        });

        return filtered;


    }

    // 4. Get doctors by department: Create a route to get doctors by department.
    @GetMapping("get-by-department/{department}")
    public List<Map<Integer, EmployeeEntity>> getByDepartment(@PathVariable String department){

        List<Map<Integer, EmployeeEntity>> filtered = new ArrayList<>();

        employees.getEmployees().forEach((id, employee) -> {

                    if(employee.getStatus().equalsIgnoreCase(department)){
                        Map<Integer, EmployeeEntity> map = new HashMap<>();
                        map.put(id, employee);
                        filtered.add(map);
                    }
        });

        return filtered;


    }






}
