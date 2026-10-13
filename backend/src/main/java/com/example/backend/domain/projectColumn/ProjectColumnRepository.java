package com.example.backend.domain.projectColumn;

import java.util.List;
import java.util.Optional;

public interface ProjectColumnRepository {
    ProjectColumn save(ProjectColumn projectColumn);

    Optional<ProjectColumn> findById(Long id);

    List<ProjectColumn> findAll();

    void deleteById(Long id);
}
