package com.ironhack.Lab402IntroToSpringBoot202302.service.impl;

import com.ironhack.Lab402IntroToSpringBoot202302.model.Hospital;
import com.ironhack.Lab402IntroToSpringBoot202302.reporitory.HospitalRepository;
import com.ironhack.Lab402IntroToSpringBoot202302.reporitory.PatientRepository;
import com.ironhack.Lab402IntroToSpringBoot202302.service.interfaces.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService implements IHospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }
}
