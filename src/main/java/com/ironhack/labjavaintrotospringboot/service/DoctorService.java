package com.ironhack.labjavaintrotospringboot.service;

import com.ironhack.labjavaintrotospringboot.model.user.Doctor;
import com.ironhack.labjavaintrotospringboot.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() { return doctorRepository.findAll(); }
    public Doctor addNewDoctor(Doctor doctor) { return doctorRepository.save(doctor); }
}
