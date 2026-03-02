package com.ironhack.springintroironhack.dto;

import java.time.LocalDate;

public record PatientResponse(
        Long id,
        String name,
        LocalDate dateOfBirth,
        Long admitted_by
) {}
