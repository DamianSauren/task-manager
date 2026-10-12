package com.example.backend.application;

import com.example.backend.domain.Project;
import com.example.backend.domain.ProjectNotFoundException;
import com.example.backend.domain.ProjectRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service()
@Transactional()
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(String name) {
        Instant now = Instant.now();

        Project project = new Project(
                null,
                name,
                now,
                now
        );

        return projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public Project getById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

}
