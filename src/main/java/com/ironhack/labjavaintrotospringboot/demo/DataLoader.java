package com.ironhack.labjavaintrotospringboot.demo;

import com.ironhack.labjavaintrotospringboot.enums.StatusEnum;
import com.ironhack.labjavaintrotospringboot.model.Employee;
import com.ironhack.labjavaintrotospringboot.model.Patient;
import com.ironhack.labjavaintrotospringboot.service.EmployeeService;
import com.ironhack.labjavaintrotospringboot.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final PatientService patientService;

    @Override
    public void run(String... args) throws Exception {

        log.info("loading employee data");
        var employee1 = new Employee(356712, "cardiology", "Alonso Flores", StatusEnum.ON_CALL);
        var employee2 = new Employee(564134, "immunology", "Sam Ortega", StatusEnum.ON);
        var employee3 = new Employee(761527, "cardiology", "German Ruiz", StatusEnum.OFF);
        var employee4 = new Employee(166552, "pulmonary", "Maria Lin", StatusEnum.ON);
        var employee5 = new Employee(156545, "orthopaedic", "Paolo Rodriguez", StatusEnum.ON_CALL);
        var employee6 = new Employee(172456, "psychiatric", "John Paul Armes", StatusEnum.OFF);
        employeeService.saveAll(List.of(employee1, employee2, employee3, employee4, employee5, employee6));

        log.info("loading patient data");
        var patient1 = new Patient("Jaime Jordan", LocalDate.of(1984, 3, 2), employee2);
        var patient2 = new Patient("Marian Garcia", LocalDate.of(1972, 1, 12), employee2);
        var patient3 = new Patient("Julia Dusterdieck", LocalDate.of(1954, 6, 11), employee1);
        var patient4 = new Patient("Steve McDuck", LocalDate.of(1931, 11, 10), employee3);
        var patient5 = new Patient("Marian Garcia", LocalDate.of(1999, 2, 15), employee6);
        patientService.saveAll(List.of(patient1, patient2, patient3, patient4, patient5));


        // Testing Lab Instructions
        employeeService.getAllDoctors().forEach(System.out::println);
        System.out.println(employeeService.getDoctorByID(356712));
        employeeService.getDoctorsByStatus(StatusEnum.ON_CALL).forEach(System.out::println);
        employeeService.getDoctorsByDepartment("carDIOlogy").forEach(System.out::println);

        patientService.getAllPatients().forEach(System.out::println);
        System.out.println(patientService.getPatientByID(1));
        patientService.getPatientsByDateOfBirthRange(
                LocalDate.of(1954, 6, 11),
                LocalDate.of(1999, 1, 31))
                .forEach(System.out::println);
        patientService.getPatientsByAdmittingDoctorsDepartment("carDIOlogy").forEach(System.out::println);
        patientService.getAllPatientsWithADoctorWhoseStatusIsOFF().forEach(System.out::println);
    }
}
