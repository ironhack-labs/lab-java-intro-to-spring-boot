package ironhack.com;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@RestController
public class PatientController {
    private static final Map<Integer, Patient> patientMap = new HashMap<>();
    private final EmployeeController employeeController = new EmployeeController();
    static {
        patientMap.put(1, new Patient(1, "Jaime Jordan", "1984-03-02", 564134));
        patientMap.put(2, new Patient(2, "Marian Garcia", "1972-01-12", 564134));
        patientMap.put(3, new Patient(3, "Julia Dusterdieck", "1954-06-11", 356712));
        patientMap.put(4, new Patient(4, "Steve McDuck", "1931-11-10", 761527));
        patientMap.put(5, new Patient(5, "Marian Garcia", "1999-02-15", 172456));
    }
    @GetMapping("/api/patients")
    public Map<Integer, Patient> getAllPatients() {
        return patientMap;
    }
    @GetMapping("/api/patients/{patientId}")
    public Patient getPatientById(@PathVariable int patientId) {
        return patientMap.get(patientId);
    }
    @GetMapping("/api/patients/by-date-range")
    public List<Patient> getPatientsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        List<Patient> patientsInRange = new ArrayList<>();
        for (Patient patient : patientMap.values()) {
            String dob = patient.getDateOfBirth();
            if (dob.compareTo(startDate) >= 0 && dob.compareTo(endDate) <= 0) {
                patientsInRange.add(patient);
            }
        }
        return patientsInRange;
    }
    @GetMapping("/api/patients/by-department/{department}")
    public List<Patient> getPatientsByDepartment(@PathVariable String department) {
        List<Patient> patientsByDept = new ArrayList<>();
        Map<Integer, Employee> employeeMap = employeeController.getEmployeeMap();
        
        for (Patient patient : patientMap.values()) {
            int admittedByEmployeeId = patient.getAdmittedBy();
            Employee admittingDoctor = employeeMap.get(admittedByEmployeeId);

            if (admittingDoctor != null && 
                admittingDoctor.getDepartment().equalsIgnoreCase(department)) {
                patientsByDept.add(patient);
            }
        }
        return patientsByDept;
    }
}

