package com.example.backend.application;

import com.example.backend.domain.project.ProjectRepository;
import com.example.backend.domain.projectColumn.ProjectColumn;
import com.example.backend.domain.projectColumn.ProjectColumnRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class ProjectColumnService {

    private final ProjectRepository projectRepository;
    private final ProjectColumnRepository projectColumnRepository;

    public ProjectColumnService(ProjectRepository projectRepository, ProjectColumnRepository projectColumnRepository) {
        this.projectRepository = projectRepository;
        this.projectColumnRepository = projectColumnRepository;
    }

    public ProjectColumn create(Long projectId, String name, int position) {
        this.validateProjectExists(projectId);

        Instant now = Instant.now();
        ProjectColumn projectColumn = new ProjectColumn(
                null,
                projectId,
                name,
                position,
                now,
                now
        );

        return projectColumnRepository.save(projectColumn);
    }

    @Transactional(readOnly = true)
    public List<ProjectColumn> getAllByProjectId(Long projectId) {
        this.validateProjectExists(projectId);

        return projectColumnRepository.findAllByProjectId(projectId);
    }

    public void deleteById(Long id) {
        projectColumnRepository.deleteById(id);
    }

    private void validateProjectExists(Long projectId) {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null.");
        }

        if (projectId <= 0) {
            throw new IllegalArgumentException("Project ID must be greater than 0.");
        }

        boolean projectExists = projectRepository.existsById(projectId);
        if (!projectExists) {
            throw new IllegalArgumentException("Project with ID " + projectId + " does not exist.");
        }
    }
}
