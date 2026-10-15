package com.example.backend.domain.projectColumn;

import java.util.List;

public interface ProjectColumnRepository {
    ProjectColumn save(ProjectColumn projectColumn);

    void deleteById(Long id);

    List<ProjectColumn> findAllByProjectId(Long projectId);
}
