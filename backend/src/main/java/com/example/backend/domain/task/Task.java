package com.example.backend.domain.task;

import java.time.Instant;

public record Task(
        Long id,
        Long projectId,
        Long columnId,
        String name,
        String description,
        int position,
        Instant createdAt,
        Instant updatedAt
) {
    public Task {
        if (projectId <= 0) {
            throw new IllegalArgumentException("ProjectId must mot be equal or less than 0");
        }

        if (columnId <= 0) {
            throw new IllegalArgumentException("ColumnId must mot be equal or less than 0");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }

        if (name.length() > 200) {
            throw new IllegalArgumentException("Name must not exceed 200 characters");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description must not be blank");
        }

        if (description.length() > 600) {
            throw new IllegalArgumentException("Description must not exceed 600 characters");
        }

        if (position < 0) {
            throw new IllegalArgumentException("Position must not be less than 0");
        }

        if (createdAt == null || updatedAt == null) {
            throw new IllegalArgumentException("Timestamps must not be null");
        }
    }
}