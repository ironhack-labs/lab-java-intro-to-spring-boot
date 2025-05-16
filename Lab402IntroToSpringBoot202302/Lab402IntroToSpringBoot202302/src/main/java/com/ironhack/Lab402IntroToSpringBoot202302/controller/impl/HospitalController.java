package com.ironhack.Lab402IntroToSpringBoot202302.controller.impl;

import com.ironhack.Lab402IntroToSpringBoot202302.controller.interfaces.IHospitalController;
import com.ironhack.Lab402IntroToSpringBoot202302.model.Employee;
import com.ironhack.Lab402IntroToSpringBoot202302.model.Hospital;
import com.ironhack.Lab402IntroToSpringBoot202302.service.interfaces.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalController implements IHospitalController {
    // Manage queries about DataBase
    // Requests
    //GET PUT DELETE PATH PATCH

    @Autowired
    private final IHospitalService hospitalService;
    //final private = is only assigned once, in the constructor, and never changes.
    // It makes your code safer, clearer and easier to maintain.
    // It is the best recommended practice in Spring Boot for controllers and services.
    public HospitalController(IHospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    //  ***************************************************  POST  ****************************************************
    @PostMapping("/hospital")
    public Hospital saveHospital(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);

    }
    //  ****************************************************  GET  ****************************************************

    @GetMapping("/hospital")
    public List<Hospital> getAllHospital() {
        return hospitalService.getAllHospital();

    }

}
