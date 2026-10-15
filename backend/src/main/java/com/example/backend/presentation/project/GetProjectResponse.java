package com.example.backend.presentation.project;

import com.example.backend.domain.project.Project;

import java.time.Instant;

public record GetProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
    public static GetProjectResponse from (Project project) {
        return new GetProjectResponse(
                project.id(),
                project.name(),
                project.createdAt(),
                project.updatedAt()
        );
    }
}
