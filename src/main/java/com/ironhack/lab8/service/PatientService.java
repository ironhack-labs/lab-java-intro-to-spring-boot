package com.ironhack.lab8.service;

import com.ironhack.lab8.model.Employee;
import com.ironhack.lab8.model.Patient;
import com.ironhack.lab8.repository.EmployeeRepository;
import com.ironhack.lab8.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public PatientService(PatientRepository patientRepository, EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.patientRepository = patientRepository;
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @Transactional
    public List<Patient> setPatients() {
        Patient patient = new Patient("Jamie Jordan", LocalDate.of(1984, 3, 2), 564134);
        Patient patient2 = new Patient("Marian Garcia", LocalDate.of(1972, 1, 12), 564133);
        Patient patient3 = new Patient("Julia Dusterdieck", LocalDate.of(1954, 6, 11), 356712);
        Patient patient4 = new Patient("Steve McDuck", LocalDate.of(1931, 11, 10), 761527);
        Patient patient5 = new Patient("Marian Garcia", LocalDate.of(1999, 2, 15), 172456);
        return patientRepository.saveAll(List.of(patient, patient2, patient3, patient4, patient5));
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getByDateOfBirth(LocalDate dateOfBirth) {
        return patientRepository.findByDateOfBirth(dateOfBirth);
    }

    public List<Patient> getByAdmittedBy(int admittedBy) {
        return patientRepository.findByAdmittedBy(admittedBy);
    }

    public List<Patient> getPatientsByDoctorsStatus(String doctorsStatus) {
        List<Employee> doctorsWithOffStatus = employeeService.getAllEmployeesByStatusOff(doctorsStatus);
        List<Long> doctorIds = doctorsWithOffStatus.stream().map(Employee::getId).toList();
        return patientRepository.findByAdmittedByIn(doctorIds);

    }


}
