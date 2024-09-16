    package com.hospital.repository;

    import com.hospital.model.Paciente;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    import java.time.LocalDate;
    import java.util.List;

    @Repository
    public interface PacienteRepository extends JpaRepository<Paciente, Long> {
        List<Paciente> findByDateOfBirthBetween(LocalDate start, LocalDate end);
        List<Paciente> findByAdmittedByDepartment(String department);
        List<Paciente> findByAdmittedByStatus(String status);
    }
