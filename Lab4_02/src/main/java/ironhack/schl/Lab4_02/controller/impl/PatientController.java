package ironhack.schl.Lab4_02.controller.impl;

import ironhack.schl.Lab4_02.model.Doctor;
import ironhack.schl.Lab4_02.model.Patient;
import ironhack.schl.Lab4_02.repository.DoctorRepository;
import ironhack.schl.Lab4_02.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    Doctor doctor;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{patient_id}")
    public Patient getPatientsById(@PathVariable Integer patient_id) {
        Optional<Patient> patientOptional = patientRepository.findById(patient_id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @GetMapping("/patients/dateOfBirth/{startDate}/{endDate}")
    public List<Patient> getPatientsByDateOfBirthRange(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return patientRepository.findAll().stream()
                .filter(patient -> patient.getDateOfBirth().isAfter(startDate) && patient.getDateOfBirth().isBefore(endDate))
                .collect(Collectors.toList());
    }

    // Get patients by admitting doctor's department

    @GetMapping("/patients/admittingDoctor/department/{department}")
    public List<Patient> getPatientsAdmittedByDoctorDepartment(@PathVariable String department) {
        List<Integer> doctorIds = doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getDepartment().equals(department))
                .map(Doctor::getEmployeeId)
                .collect(Collectors.toList());

        return patientRepository.findAll().stream()
                .filter(patient -> doctorIds.contains(patient.getAdmittedByDoctorId()))
                .collect(Collectors.toList());
    }

    // Get all patients with a doctor whose status is OFF

    @GetMapping("/patients/doctorStatus/OFF")
    public List<Patient> getPatientsByDoctorStatusOFF() {
        List<Integer> doctorIds = doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getStatus().equals("OFF"))
                .map(Doctor::getEmployeeId)
                .collect(Collectors.toList());

        return patientRepository.findAll().stream()
                .filter(patient -> doctorIds.contains(patient.getAdmittedByDoctorId()))
                .collect(Collectors.toList());
    }
}

