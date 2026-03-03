package org.example.springlab1.controller;

import org.example.springlab1.model.Employee;
import org.example.springlab1.repository.MockDataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {
    private final MockDataStore dataStore;
    public DoctorsController(MockDataStore dataStore){
        this.dataStore=dataStore;
    }

    @GetMapping
    public List<Employee> getAllDoctors(){
return dataStore.getEmployees().values().stream().collect(Collectors.toList());
    }
@GetMapping("/{id}")
    public Employee getDoctorsById(@PathVariable Long id){
        return dataStore.getEmployees().get(id);
}
@GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status){
        return dataStore.getEmployees().values().stream().filter(e->e.getStatus().equalsIgnoreCase(status)).toList();
}
@GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department){
        return dataStore.getEmployees().values().stream().filter(e->e.getDepartment().equalsIgnoreCase(department)).toList();
}

}
