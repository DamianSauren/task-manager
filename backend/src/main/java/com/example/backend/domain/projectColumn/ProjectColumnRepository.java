package com.example.backend.domain.projectColumn;

import java.util.List;
import java.util.Optional;

public interface ProjectColumnRepository {
    ProjectColumn save(ProjectColumn projectColumn);

    void deleteById(Long id);

    List<ProjectColumn> findAllByProjectId(Long projectId);
}
