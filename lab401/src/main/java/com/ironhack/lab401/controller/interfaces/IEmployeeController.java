package com.ironhack.lab401.controller.interfaces;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;

import java.util.List;

public interface IEmployeeController {
    public List<Employee> getAllDoctor();
    Employee getDoctorById(Integer employee_id);
    List<Employee> getDoctorByStatus(EmployeeStatus employeeStatus);
    List<Employee> getDoctorByDepartment(String department);

//    void saveDoctor(Employee doctor);
}
