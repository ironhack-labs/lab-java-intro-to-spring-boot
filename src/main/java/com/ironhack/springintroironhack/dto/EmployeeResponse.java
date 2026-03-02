package com.ironhack.springintroironhack.dto;

import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;

public record EmployeeResponse (
        Long id,
        Department department,
        String name,
        EmployeeStatus status
) {}
