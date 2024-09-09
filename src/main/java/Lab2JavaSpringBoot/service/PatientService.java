package Lab2JavaSpringBoot.service;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import Lab2JavaSpringBoot.model.Employee;
import Lab2JavaSpringBoot.model.Patient;
import Lab2JavaSpringBoot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> searchByBirthDateRange(LocalDate startDate, LocalDate endDate){
        return patientRepository.findByBirthDateRangeBetween(startDate, endDate);
    }

    public List<Patient> getPatientByAdmittedBy(Employee admittedBy) {
        return patientRepository.findByAdmittedBy(admittedBy);
    }

    public List<Patient> getPatientByDepartment(String department) {
        return patientRepository.findByDepartment(department);
    }

    public List<Patient> getPatientByDoctorStatus(EmployeeStatus status) {
        return patientRepository.findByStatusEmployee(status);
    }


}