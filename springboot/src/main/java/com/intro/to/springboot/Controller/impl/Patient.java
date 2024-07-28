package com.intro.to.springboot.Controller.impl;

import com.intro.to.springboot.Service.PatientService;

import java.util.Collections;
import java.util.List;

public class Patient {
        Patient() {
            PatientService patientService = null;
            List<com.intro.to.springboot.model.Patient> patientsWithDoctorStatusOff;
            patientsWithDoctorStatusOff = Collections.unmodifiableList(patientService.getPatientsWithDoctorStatusOff());
        }
}
