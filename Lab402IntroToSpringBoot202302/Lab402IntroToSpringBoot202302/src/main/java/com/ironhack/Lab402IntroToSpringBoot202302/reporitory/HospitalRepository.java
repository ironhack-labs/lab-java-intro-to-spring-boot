package com.ironhack.Lab402IntroToSpringBoot202302.reporitory;

import com.ironhack.Lab402IntroToSpringBoot202302.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // here custom methods if I need them

}
