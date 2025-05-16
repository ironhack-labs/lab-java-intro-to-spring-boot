package com.ironhack.Lab402IntroToSpringBoot202302.service.interfaces;

import com.ironhack.Lab402IntroToSpringBoot202302.model.Hospital;

import java.util.List;

public interface IHospitalService {

    Hospital saveHospital(Hospital hospital);

    List<Hospital> getAllHospital();
}
