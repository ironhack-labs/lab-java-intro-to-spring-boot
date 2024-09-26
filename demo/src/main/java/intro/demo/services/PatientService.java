package intro.demo.services;

import intro.demo.model.Employee;
import intro.demo.model.Patient;
import intro.demo.repositories.EmployeeRepository;
import intro.demo.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final EmployeeRepository employeeRepository;

    public PatientService(PatientRepository patientRepository, EmployeeRepository employeeRepository) {
        this.patientRepository = patientRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) throws EntityNotFoundException {
        return patientRepository.findById(patientId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Patient> getPatientsByDateOfBirthRange(String startDate, String endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatientsByAdmittingDoctorsDepartment(String department) {
        return patientRepository.findByAdmittingDoctorDepartment(department);
    }

    public List<Patient> getPatientsWithDoctorsStatusOFF() {
        return patientRepository.findPatientsByDoctorStatus("OFF");
    }
}