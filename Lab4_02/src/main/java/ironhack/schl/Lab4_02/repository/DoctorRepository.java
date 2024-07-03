package ironhack.schl.Lab4_02.repository;

import ironhack.schl.Lab4_02.model.Doctor;
import ironhack.schl.Lab4_02.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAllByDepartment(String department);

    List<Doctor> findAllByStatus(Status status);
}
