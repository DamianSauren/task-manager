package com.example.backend.infrastructure.persistence;

import com.example.backend.domain.Project;
import com.example.backend.domain.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class ProjectRepositoryAdapter implements ProjectRepository {

    private final SpringDataProjectRepository jpaRepository;

    public ProjectRepositoryAdapter(
            SpringDataProjectRepository jpaRepository
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
                .map(ProjectRepositoryAdapter::toDomain);
    }

    @Override
    public List<Project> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(ProjectRepositoryAdapter::toDomain)
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
