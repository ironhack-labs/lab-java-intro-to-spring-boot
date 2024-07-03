package ironhack.schl.Lab4_02.controller.impl;

import ironhack.schl.Lab4_02.model.Doctor;
import ironhack.schl.Lab4_02.model.Status;
import ironhack.schl.Lab4_02.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;
    private Status status;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{employeeId}")
    public Doctor getDoctorsById(@PathVariable Integer employeeId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(employeeId);
        if (doctorOptional.isEmpty()) return null;
        return doctorOptional.get();
    }
    // Get doctors by status

    @GetMapping("/doctors/status/{status}")
    public List<Doctor> getDoctorsByStatus(@PathVariable String status) {
        return doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    // Get doctors by department

    @GetMapping("/doctors/department/{department}")
    public List<Doctor> getDoctorsByDepartment(@PathVariable String department) {
        return doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

}