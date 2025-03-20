package com.ironhack.lab401.service.interfaces;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;
import org.hibernate.engine.spi.Status;


import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllDoctor();
    Employee getDoctorById(Integer employee_id);
    List<Employee> getDoctorByStatus(EmployeeStatus employeeStatus);
    List<Employee> getDoctorByDepartment(String department);

//    void saveDoctor(Employee doctor);
}
