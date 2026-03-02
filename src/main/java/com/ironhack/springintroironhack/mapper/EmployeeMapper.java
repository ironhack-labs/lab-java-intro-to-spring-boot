package com.ironhack.springintroironhack.mapper;

import com.ironhack.springintroironhack.dto.EmployeeResponse;
import com.ironhack.springintroironhack.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeResponse toResponse(EmployeeEntity employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getDepartment(),
                employee.getName(),
                employee.getStatus()
        );
    }
}
