package com.ironhack.Lab402IntroToSpringBoot202302.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdDTO {
    @NotNull(message = "Id cannot be empty")
    private Long id;

}
