package com.example.lab_java_intro_to_spring_boot.controller.interfaces;

import com.example.lab_java_intro_to_spring_boot.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IPatientController {

    List<Patient> getAllPatient();
    Patient getPatientId(Integer id);
}
