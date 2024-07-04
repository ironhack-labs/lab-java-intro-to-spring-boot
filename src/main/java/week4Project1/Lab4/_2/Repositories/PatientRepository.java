package week4Project1.Lab4._2.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import week4Project1.Lab4._2.Models.Employee;
import week4Project1.Lab4._2.Models.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> AdmittedBy(Employee employee);
    List<Patient> findByDateOfBirthBetween(String startDate, String endDate);

}
