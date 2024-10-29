package org.example.springbootlab.dataloader;

import org.example.springbootlab.model.Doctor;
import org.example.springbootlab.model.Patient;
import org.example.springbootlab.repository.DoctorRepository;
import org.example.springbootlab.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public DataLoader(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Doctor doctor1 = new Doctor(356712L, "cardiology", "Alonso Flores", "ON_CALL");
        Doctor doctor2 = new Doctor(564134L, "immunology", "Sam Ortega", "ON");
        Doctor doctor3 = new Doctor(761527L, "cardiology", "German Ruiz", "OFF");
        Doctor doctor4 = new Doctor(166552L, "pulmonary", "Maria Lin", "ON");
        Doctor doctor5 = new Doctor(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
        Doctor doctor6 = new Doctor(172456L, "psychiatric", "John Paul Armes", "OFF");

        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);
        doctorRepository.save(doctor4);
        doctorRepository.save(doctor5);
        doctorRepository.save(doctor6);


        Patient patient1 = new Patient(1L, "Jaime Jordan", "1984-03-02", doctor2);
        Patient patient2 = new Patient(2L, "Marian Garcia", "1972-01-12", doctor2);
        Patient patient3 = new Patient(3L, "Julia Dusterdiek", "1954-06-11", doctor1);
        Patient patient4 = new Patient(4L, "Steve McDuck", "1931-11-10", doctor3);
        Patient patient5 = new Patient(5L, "Marian Garcia", "1999-02-15", doctor6);

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);
        patientRepository.save(patient5);
    }
}