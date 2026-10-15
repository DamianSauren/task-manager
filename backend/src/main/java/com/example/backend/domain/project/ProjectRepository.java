package com.example.backend.domain.project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);

    Optional<Project> findById(Long id);

    List<Project> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
