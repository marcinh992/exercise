package com.exercise.starservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record StarDto(

        Long id,

        @NotBlank(message = "Name is mandatory")
        String name,

        @Min(value = 0, message = "Distance must be a positive number")
        long distance) {
}
