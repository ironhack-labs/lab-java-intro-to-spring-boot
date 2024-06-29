import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getDoctorById(@PathVariable("id") Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
}
