@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    @GetMapping("/status/{status}")
    public List<Employee> getByStatus(@PathVariable EmployeeStatus status) {
        return employeeRepo.findByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return employeeRepo.findByDepartment(department);
    }
}
