package com.example.backend.domain.projectColumn;

import java.time.Instant;

public record ProjectColumn(
        Long id,
        Long projectId,
        String name,
        int position,
        Instant createdAt,
        Instant updatedAt
) {
    public ProjectColumn {
        if (projectId <= 0) {
            throw new IllegalArgumentException("ProjectId must mot be equal or less than 0");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }

        if (name.length() > 200) {
            throw new IllegalArgumentException("Name must not exceed 200 characters");
        }

        if (position < 0) {
            throw new IllegalArgumentException("Position must not be less than 0");
        }

        if (createdAt == null || updatedAt == null) {
            throw new IllegalArgumentException("Timestamps must not be null");
        }
    }
}
