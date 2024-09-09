package Lab2JavaSpringBoot;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import Lab2JavaSpringBoot.model.Employee;
import Lab2JavaSpringBoot.model.Patient;
import Lab2JavaSpringBoot.repository.EmployeeRepository;
import Lab2JavaSpringBoot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee();
        e1.setEmployeeId(356712L);
        e1.setDepartment("cardiology");
        e1.setName("Alonso Flores");
        e1.setEmployeeStatus(EmployeeStatus.ON_CALL);
        //pongo la asignacion esta final de e1 = ... porque al darle un id, entra en conflicto con el generatedValue del
        //modelo y sin esto no funciona
        e1 = employeeRepository.save(e1);

        Employee e2 = new Employee();
        e2.setEmployeeId(564134L);
        e2.setDepartment("immunology");
        e2.setName("Sam Ortega");
        e2.setEmployeeStatus(EmployeeStatus.ON);
        e2 = employeeRepository.save(e2);

        Employee e3 = new Employee();
        e3.setEmployeeId(761527L);
        e3.setDepartment("cardiology");
        e3.setName("Alemán Ruiz");
        e3.setEmployeeStatus(EmployeeStatus.OFF);
        e3 = employeeRepository.save(e3);

        Employee e4 = new Employee();
        e4.setEmployeeId(166552L);
        e4.setDepartment("pulmonary");
        e4.setName("María Lin");
        e4.setEmployeeStatus(EmployeeStatus.ON);
        e4 = employeeRepository.save(e4);

        Employee e5 = new Employee();
        e5.setEmployeeId(156545L);
        e5.setDepartment("orthopaedic");
        e5.setName("Pablo Rodríguez");
        e5.setEmployeeStatus(EmployeeStatus.ON_CALL);
        e5 = employeeRepository.save(e5);

        Employee e6 = new Employee();
        e6.setEmployeeId(172456L);
        e6.setDepartment("psychiatric");
        e6.setName("Juan Pablo Armes");
        e6.setEmployeeStatus(EmployeeStatus.OFF);
        e6 = employeeRepository.save(e6);

        Patient p1 = new Patient();
        p1.setName("Jaime Jordán");
        p1.setDateOfBirth(LocalDate.of(1984, 3, 2));
        p1.setAdmittedBy(e2);
        patientRepository.save(p1);

        Patient p2 = new Patient();
        p2.setName("Mariona García");
        p2.setDateOfBirth(LocalDate.of(1972, 1, 12));
        p2.setAdmittedBy(e2);
        patientRepository.save(p2);

        Patient p3 = new Patient();
        p3.setPatientId(3L);
        p3.setName("Julia Dusterdieck");
        p3.setDateOfBirth(LocalDate.of(1954, 6, 11));
        p3.setAdmittedBy(e1);
        patientRepository.save(p3);

        Patient p4 = new Patient();
        p4.setPatientId(4L);
        p4.setName("Steve McDuck");
        p4.setDateOfBirth(LocalDate.of(1931, 11, 10));
        p4.setAdmittedBy(e3);
        patientRepository.save(p4);

        Patient p5 = new Patient();
        p5.setPatientId(5L);
        p5.setName("Marian García");
        p5.setDateOfBirth(LocalDate.of(1999, 2, 15));
        p5.setAdmittedBy(e6);
        patientRepository.save(p5);
    }
}
