package service;

import model.Employee;
import model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllDoctors(){
        return employeeRepository.findAll();
    }

    public Employee addNewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.deleteById(id);

    }

    public Optional<Employee> findDoctorById(Integer employeeId){
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> findDoctorsByStatus(Status status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> findDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
