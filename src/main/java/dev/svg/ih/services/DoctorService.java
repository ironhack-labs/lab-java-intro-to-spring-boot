package dev.svg.ih.services;

import dev.svg.ih.model.Doctor;
import dev.svg.ih.model.Patient;
import dev.svg.ih.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorsById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorsByStatus(String status) {
        return doctorRepository.findByStatus(status);
    }

    public List<Doctor> getDoctorsByDepartment(String department) {
        return doctorRepository.findByDepartment(department);
    }

    public List<Doctor> getDoctorsByStatusAndDepartment(String status, String department) {
        return doctorRepository.findByStatusAndDepartment(status, department);
    }

    public List<Patient> getPatientsWithDoctorHavingStatusOff() {
        return doctorRepository.findPatientsWithDoctorHavingStatusOff();
    }


}
