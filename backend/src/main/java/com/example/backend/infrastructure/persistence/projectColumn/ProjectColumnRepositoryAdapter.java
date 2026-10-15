package com.example.backend.infrastructure.persistence.projectColumn;

import com.example.backend.domain.projectColumn.ProjectColumn;
import com.example.backend.domain.projectColumn.ProjectColumnRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class ProjectColumnRepositoryAdapter implements ProjectColumnRepository {

    private final SpringDataProjectColumnRepository jpaRepository;

    public ProjectColumnRepositoryAdapter(
            SpringDataProjectColumnRepository jpaRepository
    ) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ProjectColumn save(ProjectColumn projectColumn) {
        var entity = new ProjectColumnJpaEntity(
                projectColumn.id(),
                projectColumn.projectId(),
                projectColumn.name(),
                projectColumn.position(),
                projectColumn.createdAt(),
                projectColumn.updatedAt()
        );

        var saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<ProjectColumn> findAllByProjectId(Long projectId) {
        return jpaRepository.findAllByProjectId(projectId)
                .stream()
                .map(ProjectColumnRepositoryAdapter::toDomain)
                .toList();

    }

    private static ProjectColumn toDomain(ProjectColumnJpaEntity entity) {
        return new ProjectColumn(
                entity.getId(),
                entity.getProjectId(),
                entity.getName(),
                entity.getPosition(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
