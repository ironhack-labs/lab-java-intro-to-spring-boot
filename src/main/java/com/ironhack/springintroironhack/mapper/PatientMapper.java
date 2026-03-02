package com.ironhack.springintroironhack.mapper;

import com.ironhack.springintroironhack.dto.PatientResponse;
import com.ironhack.springintroironhack.entity.PatientEntity;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public PatientResponse toResponse(PatientEntity patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getName(),
                patient.getDateOfBirth(),
                patient.getAdmitted_by()
        );
    }
}
