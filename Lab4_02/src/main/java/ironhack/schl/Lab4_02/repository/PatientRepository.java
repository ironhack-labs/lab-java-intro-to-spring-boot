package ironhack.schl.Lab4_02.repository;

import ironhack.schl.Lab4_02.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
   // List<Patient> getPatientsByDateOfBirthRange(String date1, String date2);
}
