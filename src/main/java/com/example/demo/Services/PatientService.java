
package com.example.demo.Services;

import com.example.demo.Classes.Patient;
import com.example.demo.Repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

    @Service
    public class PatientService {
        private final PatientRepository patientRepository;

        public PatientService(PatientRepository patientRepository) {
            this.patientRepository = patientRepository;
        }

        public List<Patient> getAllPatients() {
            return patientRepository.findAll();
        }

        public Patient getPatientById(Long id) {
            return patientRepository.findById(id).orElse(null);
        }

        public Patient savePatient(Patient patient) {
            return patientRepository.save(patient);
        }

        public void deletePatient(Long id) {
            patientRepository.deleteById(id);
        }

        public List<Patient> getPatientsByDobRange(Date start, Date end) {
            return patientRepository.getPatientsByDobRange(start, end);
        }

        public List<Patient> getPatientsByAdmittingDoctorsDepartment(String department) {
            return patientRepository.findByAdmittingDoctorsDepartment(department);
        }

        public List<Patient> getPatientsWithDoctorOff() {
            return patientRepository.findByDoctorStatusOff();
        }
    }
