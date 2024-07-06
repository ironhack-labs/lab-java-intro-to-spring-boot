import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Main Application
@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
}

// Employee Entity
@Entity
class Employee {
    @Id
    private Long id;
    private String department;
    private String name;
    private String status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

// Patient Entity
@Entity
class Patient {
    @Id
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public Employee getAdmittedBy() { return admittedBy; }
    public void setAdmittedBy(Employee admittedBy) { this.admittedBy = admittedBy; }
}

// Employee Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}

// Patient Repository
interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy.id = e.id WHERE e.department = :department")
    List<Patient> findPatientsByAdmittingDoctorDepartment(@Param("department") String department);

    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy.id = e.id WHERE e.status = 'OFF'")
    List<Patient> findPatientsWithDoctorStatusOff();
}

// Controller
@RestController
@RequestMapping("/api")
class HospitalController {
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    public HospitalController(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }

    // 1. Get all doctors
    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    // 2. Get doctor by ID
    @GetMapping("/doctor/{employeeId}")
    public Optional<Employee> getDoctorById(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    // 3. Get doctors by status
    @GetMapping("/doctors/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeRepository.findByStatus(status);
    }

    // 4. Get doctors by department
    @GetMapping("/doctors/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }

    // 5. Get all patients
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // 6. Get patient by ID
    @GetMapping("/patient/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable Long patientId) {
        return patientRepository.findById(patientId);
    }

    // 7. Get patients by date of birth range
    @GetMapping("/patients/dob_range")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {
        return patientRepository.findByDateOfBirthBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    // 8. Get patients by admitting doctor's department
    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorsDepartment(@PathVariable String department) {
        return patientRepository.findPatientsByAdmittingDoctorDepartment(department);
    }

    // 9. Get all patients with a doctor whose status is OFF
    @GetMapping("/patients/doctor_status_off")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientRepository.findPatientsWithDoctorStatusOff();
    }
}
