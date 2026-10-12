package com.example.backend.domain;

import java.time.Instant;

public record Project (
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
    public Project {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }

        if (name.length() > 200) {
            throw new IllegalArgumentException("Name must not exceed 200 characters");
        }

        if (createdAt == null || updatedAt == null) {
            throw new IllegalArgumentException("Timestamps must not be null");
        }
    }
}
