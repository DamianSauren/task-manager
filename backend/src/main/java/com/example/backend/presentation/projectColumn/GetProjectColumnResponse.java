package com.example.backend.presentation.projectColumn;

import com.example.backend.domain.projectColumn.ProjectColumn;

import java.time.Instant;

public record GetProjectColumnResponse(
        Long id,
        Long projectId,
        String name,
        int position,
        Instant createdAt,
        Instant updatedAt
) {
    public static GetProjectColumnResponse from(ProjectColumn projectColumn) {
        return new GetProjectColumnResponse(
                projectColumn.id(),
                projectColumn.projectId(),
                projectColumn.name(),
                projectColumn.position(),
                projectColumn.createdAt(),
                projectColumn.updatedAt()
        );
    }
}
