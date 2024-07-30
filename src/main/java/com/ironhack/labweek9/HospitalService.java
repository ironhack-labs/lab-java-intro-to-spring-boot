package com.ironhack.labweek9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    public Employee getDoctorById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getDoctorsByStatus(Status status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate start, LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    public List<Patient> getPatientsByAdmittingDoctorDepartment(String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientRepository.findByAdmittedBy_Status(Status.OFF);
    }
}

