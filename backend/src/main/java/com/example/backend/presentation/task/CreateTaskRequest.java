package com.example.backend.presentation.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(
        @NotNull
        @Positive
        Long projectId,

        @NotNull
        @Positive
        Long columnId,

        @NotBlank
        @Size(max = 200)
        String name,

        @NotBlank
        @Size(max = 600)
        String description,

        @PositiveOrZero
        int position
) {
}
