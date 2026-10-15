package com.example.backend.domain.task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    List<Task> findAllByProjectId(Long projectId);

    void deleteById(Long id);
}
