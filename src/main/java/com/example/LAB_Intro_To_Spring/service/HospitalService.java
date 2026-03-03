package com.example.LAB_Intro_To_Spring.service;

import com.example.LAB_Intro_To_Spring.model.Employee;
import com.example.LAB_Intro_To_Spring.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {
    private List<Employee> employees=new ArrayList<>();
    private List<Patient> patients=new ArrayList<>();

    public HospitalService(){
//        Employees
        employees.add(new Employee(356712, "cardiology", "Alonso Flores", "ON_CALL"));
        employees.add(new Employee(564134, "immunology", "Sam Ortega", "ON"));
        employees.add(new Employee(761527, "cardiology", "German Ruiz", "OFF"));
        employees.add(new Employee(166552, "pulmonary", "Maria Lin", "ON"));
        employees.add(new Employee(156545, "orthopaedic", "Paolo Rodriguez", "ON_CALL"));
        employees.add(new Employee(172456, "psychiatric", "John Paul Armes", "OFF"));
        employees.add(new Employee(212456, "cardiology", "Leyla Ahmedova", "ON"));
        employees.add(new Employee(312456, "neurology", "Murad Ismayilov", "ON_CALL"));
        employees.add(new Employee(412456, "immunology", "Sona Valiyeva", "OFF"));
        employees.add(new Employee(512456, "pulmonary", "Elvin Qasimov", "ON"));

//        Patients
        patients.add(new Patient(1, "Jaime Jordan", "1984-03-02", 264134));
        patients.add(new Patient(2, "Marian Garcia", "1972-01-12", 564134));
        patients.add(new Patient(3, "Julia Dusterdieck", "1954-06-11", 356712));
        patients.add(new Patient(4, "Steve McDuck", "1931-11-10", 761527));
        patients.add(new Patient(5, "Marian Garcia", "1999-02-15", 172456));
        patients.add(new Patient(6, "Ali Rzayev", "1990-05-20", 212456));
        patients.add(new Patient(7, "Aysel Mammadi", "1985-12-30", 312456));
        patients.add(new Patient(8, "Vugar Aliyev", "2005-01-15", 412456));
        patients.add(new Patient(9, "Nigar Heydarova", "1978-08-22", 512456));
        patients.add(new Patient(10, "Kanan Karimov", "2010-03-10", 356712));
    }
    public List<Employee> getAllEmployees(){
        return employees;
    }
    public Employee getEmployeeById(int id){
        return employees.stream().filter(e->e.getEmployeeId()==id).findFirst().orElse(null);
    }
    public List<Employee> getEmployeeByStatus(String status){
        return employees.stream().filter(e->e.getStatus().equalsIgnoreCase(status)).toList();
    }
    public List<Employee> getDoctorsByDepartment(String dept){
        return employees.stream().filter(e->
                e.getDepartment().equalsIgnoreCase(dept)).toList();
    }
    public Patient getPatientById(int id){
        return patients.stream().filter(p->p.getPatient_id()==id).findFirst().orElse(null);
    }
    public List<Patient> getPatientsByBirthRange(String start,String end){
        return  patients.stream().filter(p->p.getDate_of_birth().compareTo(start)>=0 && p.getDate_of_birth().compareTo(end)<=0).toList();
    }
    public List<Patient> getPatientsWithDoctorOff(){
        return patients.stream().filter(p->{
            Employee doc=getEmployeeById(p.getAdmitted_by());
            return doc!=null&&doc.getStatus().equalsIgnoreCase("OFF");
        }).toList();
    }
    public List<Patient> getAllPatients() {
        return patients;
    }
}
