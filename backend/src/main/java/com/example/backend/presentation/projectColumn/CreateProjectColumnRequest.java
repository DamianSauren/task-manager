package com.example.backend.presentation.projectColumn;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateProjectColumnRequest(
        @NotBlank
        @Size(max = 200)
        String name,

        @PositiveOrZero
        int position
) {
}
