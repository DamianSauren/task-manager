package com.example.backend.presentation.task;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record UpdateTaskPositionRequest(
        @NotNull
        @Positive
        Long columnId,

        @PositiveOrZero
        int position
) {
}
