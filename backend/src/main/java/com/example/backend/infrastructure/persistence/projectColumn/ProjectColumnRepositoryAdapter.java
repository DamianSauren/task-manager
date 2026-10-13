package com.example.backend.infrastructure.persistence.projectColumn;

import com.example.backend.domain.project.Project;
import com.example.backend.domain.project.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class ProjectColumnRepositoryAdapter implements ProjectRepository {

    private final SpringDataProjectColumnRepository jpaRepository;

    public ProjectColumnRepositoryAdapter(
            SpringDataProjectColumnRepository jpaRepository
    ) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Project save(Project project) {
        var entity = new ProjectJpaEntity(
                project.id(),
                project.name(),
                project.createdAt(),
                project.updatedAt()
        );

        var saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return jpaRepository.findById(id)
                .map(ProjectColumnRepositoryAdapter::toDomain);
    }

    @Override
    public List<Project> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(ProjectColumnRepositoryAdapter::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private static Project toDomain(ProjectJpaEntity entity) {
        return new Project (
                entity.getId(),
                entity.getName(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
