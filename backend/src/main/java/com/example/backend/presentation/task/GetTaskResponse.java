package com.example.backend.presentation.task;

import com.example.backend.domain.task.Task;

import java.time.Instant;

public record GetTaskResponse(
        Long id,
        Long projectId,
        Long columnId,
        String name,
        String description,
        int position,
        Instant createdAt,
        Instant updatedAt
) {
    public static GetTaskResponse from(Task task) {
        return new GetTaskResponse(
                task.id(),
                task.projectId(),
                task.columnId(),
                task.name(),
                task.description(),
                task.position(),
                task.createdAt(),
                task.updatedAt()
        );
    }
}
