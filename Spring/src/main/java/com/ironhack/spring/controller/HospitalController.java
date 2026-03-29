package com.ironhack.spring.controller;

import com.ironhack.spring.Enums.Status;
import com.ironhack.spring.model.Employee;
import com.ironhack.spring.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.*;

@RestController
public class HospitalController {
    private final HashMap<Long , Employee > employeeHashMap = new HashMap<Long, Employee>();
    private final HashMap<Long , Patient> patientHashMap = new HashMap<Long , Patient>();

    private Date toDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    public HospitalController() {


        Employee e1 = new Employee(356712, "cardiology", "Alonso Flores", Status.ON_CALL);
        Employee e2 =new Employee(564134, "immunology", "Sam Ortega", Status.ON);
        Employee e3 = new Employee(761527, "cardiology", "German Ruiz", Status.OFF);
        Employee e4 = new Employee(166552, "pulmonary", "Maria Lin", Status.ON);
        Employee e5 = new Employee(156545, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL);
        Employee e6 = new Employee(172456, "psychiatric", "John Paul Armes", Status.OFF);

        employeeHashMap.put(e1.getId(), e1);
        employeeHashMap.put(e2.getId(), e2);
        employeeHashMap.put(e3.getId(), e3);
        employeeHashMap.put(e4.getId(), e4);
        employeeHashMap.put(e5.getId(), e5);
        employeeHashMap.put(e6.getId(), e6);




        Patient p1 = new Patient(1, "Jaime Jordan", 564134, toDate(1984, 3, 2));
        Patient p2 = new Patient(2, "Marian Garcia", 564134, toDate(1972, 1, 12));
        Patient p3 = new Patient(3, "Julia Dusterdieck", 356712, toDate(1954, 6, 11));
        Patient p4 = new Patient(4, "Steve McDuck", 761527, toDate(1931, 11, 10));
        Patient p5 = new Patient(5, "Marian Garcia", 172456, toDate(1999, 2, 15));


        patientHashMap.put(p1.getPatient_id() , p1);
        patientHashMap.put(p2.getPatient_id() , p2);
        patientHashMap.put(p3.getPatient_id() , p3);
        patientHashMap.put(p4.getPatient_id() , p4);
        patientHashMap.put(p5.getPatient_id() , p5);
    }
    //For all employees
    @GetMapping("/employees")
    public List<Employee> getallEmployees(){
        return new ArrayList<>(employeeHashMap.values());
    }

    //For all patients
    @GetMapping("/patients")
    public List<Patient> getallPatients(){
        return new ArrayList<>(patientHashMap.values());
    }

    //For employee by id
    @GetMapping("/employees/{employee_id}")
    public Employee getEmployeeById(@PathVariable long employee_id){
        Employee employee = employeeHashMap.get(employee_id);
        if(employee == null){
            throw new RuntimeException("There is not any patient with this is");
        }
        return employee;
    }

    //For patient with this id
    @GetMapping("/patients/{patient_id}")
    public Patient getPatientByID(@PathVariable long patient_id){
        Patient patient  = patientHashMap.get(patient_id);
        if(patient == null ){
            throw new RuntimeException("There is not any patient with this id");
        }
        return patient;
    }

    //According to Status
    @GetMapping("/employees/doctors/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable Status status){
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeHashMap.values()){
            if(employee.getStatus() == status ){
                employees.add(employee);
            }
        }
        return employees;

    }

    //Where Status is OFF
    @GetMapping("/employees/status/OFF")
    public List<Patient> getEmployeesStatusIsOFF(){
        List<Patient> patients = new ArrayList<>();
        for(Patient patient : patientHashMap.values()){
            Employee doctor = employeeHashMap.get(patient.getAdmitted_by());
            if(doctor.getStatus() == Status.OFF){
                patients.add(patient);
            }
        }
        return patients;
    }

    @GetMapping("/employees/departments/{department}")
    public List<Employee> getEmployeesByDepName(@PathVariable String department){
        List<Employee> employees = new ArrayList<>();
        for(Employee employee : employeeHashMap.values()){
            if(employee.getDepartment() == department){
                employees.add(employee);
            }
        }
        return employees;
    }


    @GetMapping("/patients/by-dob")
    public List<Patient> getPatientsByDobRange(
            @RequestParam Date start,
            @RequestParam Date end) {

        List<Patient> patients = new ArrayList<>();

        for (Patient patient : patientHashMap.values()) {

            Date dob = patient.getDate_of_birth();

            if (dob.after(start) && dob.before(end)) {
                patients.add(patient);
            }
        }

        return patients;
    }

    @GetMapping("/patients/admitted-by-department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {

        Set<Long> doctorIdsInDepartment = new HashSet<>();

        for (Employee e : employeeHashMap.values()) {
            if (e.getDepartment().equalsIgnoreCase(department)) {
                doctorIdsInDepartment.add(e.getId());
            }
        }

        List<Patient> result = new ArrayList<>();

        for (Patient p : patientHashMap.values()) {
            if (doctorIdsInDepartment.contains(p.getAdmitted_by())) {
                result.add(p);
            }
        }

        return result;
    }
}
