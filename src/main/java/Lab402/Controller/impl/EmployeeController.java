package Lab402.Controller.impl;

import Lab402.Repository.EmployeeRepository;
import Lab402.model.Employee;
import Lab402.model.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors(){
        return employeeRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

// findByDepartment
    @GetMapping("/doctors/department/{department}")
    public List<Employee> findAllByDepartment(@PathVariable String department){
        return employeeRepository.findAllByDepartment(department);

    }

//Get doctors by status:
    @GetMapping("/doctors/status/{employeeStatus}")
    public List<Employee> findAllByEmployeeStatus(@PathVariable EmployeeStatus employeeStatus){
        return employeeRepository.findAllByEmployeeStatus(employeeStatus);
    }

}
