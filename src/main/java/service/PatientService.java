package service;

import model.EmployeeStatus;
import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PatientRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findByPatientId(int patientId) {
        return patientRepository.findByPatientId(patientId);
    }

    public List<Patient> findAllByDateOfBirthBetween(Date minDate, Date maxDate) {
        return patientRepository.findAllByDateOfBirthBetween(minDate, maxDate);
    }

    public List<Patient> findAllByDoctorDepartment(String department) {
        return patientRepository.findAllByDoctorDepartment(department);
    }

    public List<Patient> findAllByDoctorStatus(EmployeeStatus status) {
        return patientRepository.findAllByDoctorStatus(status);
    }

    public List<Patient> findAllByDoctorStatusIsOff() {
        return patientRepository.findAllByDoctorStatusIsOff();
    }
}