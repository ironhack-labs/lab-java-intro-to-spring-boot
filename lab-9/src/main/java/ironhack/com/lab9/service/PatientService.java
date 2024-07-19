package ironhack.com.lab9.service;

import ironhack.com.lab9.model.Patient;
import ironhack.com.lab9.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> findAll() {
        log.info("Listing all patients");
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long patientId) {
        log.info("Listing a patient with id: {}", patientId);
        return patientRepository.findById(patientId);
    }

    public List<Patient> findPatientByDateBetween(String startDate, String endDate) {
        log.info("Listing all patients between date {} and {}", startDate, endDate);
        return patientRepository.findPatientByDateBetween(startDate, endDate);
    }

    public List<Patient> findPatientByDoctorDepartment(String department) {
        log.info("Listing all patients that have doctor from the department: {}", department );
        return patientRepository.findPatientByDoctorDepartment(department);
    }

    public List<Patient> findPatientByDoctorStatusOff(){
        log.info("List all patients who doctor's status is off");
        return patientRepository.findPatientByDoctorStatusOff();
    }

    public Patient addPatient(Patient patient){
        log.info("Adding new patient{}", patient);
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long patientId, Patient patient){
        log.info("Updating patient with id{}", patientId);

        var patientToUpdate = patientRepository.findById(patientId).orElseThrow();
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setDate(patient.getDate());
        patientToUpdate.setEmployeeId(patient.getEmployeeId());

        return  patientRepository.save(patientToUpdate);


    }


}
