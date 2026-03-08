package org.ironhack.collections.lab.Service;

import org.ironhack.collections.lab.Model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    private List<Patient> patients = List.of(
            new Patient(1,"Jaime Jordan", LocalDate.parse("1984-03-02"),564134),
            new Patient(2,"Marian Garcia", LocalDate.parse("1972-01-12"),564134),
            new Patient(3,"Julia Dusterdieck", LocalDate.parse("1954-06-11"),356712),
            new Patient(4,"Steve McDuck", LocalDate.parse("1931-11-10"),761527),
            new Patient(5,"Marian Garcia", LocalDate.parse("1999-02-15"),172456)
    );

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientById(int id){
        return patients.stream()
                .filter(p -> p.getPatientId() == id)
                .findFirst()
                .orElse(null);
    }
}
