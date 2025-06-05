@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepo;

    @GetMapping
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return patientRepo.findById(id).orElseThrow();
    }

    @GetMapping("/dob")
    public List<Patient> getByDobRange(@RequestParam String start, @RequestParam String end) {
        return patientRepo.findByDateOfBirthBetween(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/department/{department}")
    public List<Patient> getByAdmittingDoctorDepartment(@PathVariable String department) {
        return patientRepo.findByAdmittedBy_Department(department);
    }

    @GetMapping("/doctor-status/{status}")
    public List<Patient> getByDoctorStatus(@PathVariable EmployeeStatus status) {
        return patientRepo.findByAdmittedBy_Status(status);
    }
}
