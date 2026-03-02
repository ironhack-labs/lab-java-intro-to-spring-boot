package ironhack.com;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@RestController
public class EmployeeController {

    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    static {
        employeeMap.put(356712, new Employee(356712, "cardiology", "Alonso Flores", Status.ON_CALL));
        employeeMap.put(564134, new Employee(564134, "immunology", "Sam Ortega", Status.ON));
        employeeMap.put(761527, new Employee(761527, "cardiology", "German Ruiz", Status.OFF));
        employeeMap.put(166552, new Employee(166552, "pulmonary", "Maria Lin", Status.ON));
        employeeMap.put(156545, new Employee(156545, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL));
        employeeMap.put(172456, new Employee(172456, "psychiatric", "John Paul Armes", Status.OFF));
    }

    @GetMapping("/api/doctors")
    public Map<Integer, Employee> getAllDoctors() {
        return employeeMap;
    }
    @GetMapping("/api/doctors/{employee_id}")
    public Employee getDoctorById(@PathVariable int employee_id) {
        return employeeMap.get(employee_id);
    }

    @GetMapping("/api/doctors/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        List<Employee> doctorsByStatus = new ArrayList<>();
        Status statusEnum;
        
        try {
            statusEnum = Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            return doctorsByStatus; 
        }
        
        for (Employee employee : employeeMap.values()) {
            if (employee.getStatus() == statusEnum) {
                doctorsByStatus.add(employee);
            }
        }
        return doctorsByStatus;
    }

    @GetMapping("/api/doctors/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        List<Employee> doctorsByDept = new ArrayList<>();
        
        for (Employee employee : employeeMap.values()) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                doctorsByDept.add(employee);
            }
        }
        return doctorsByDept;
    }

    public Map<Integer, Employee> getEmployeeMap() {
        return employeeMap;
    }
}

