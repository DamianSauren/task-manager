package com.example.backend.infrastructure.persistence.task;

import com.example.backend.domain.task.Task;
import com.example.backend.domain.task.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class TaskRepositoryAdapter implements TaskRepository {

    private final SpringDataTaskRepository jpaRepository;

    public TaskRepositoryAdapter(
            SpringDataTaskRepository jpaRepository
    ) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Task save(Task task) {
        var entity = new TaskJpaEntity(
                task.id(),
                task.projectId(),
                task.columnId(),
                task.name(),
                task.description(),
                task.position(),
                task.createdAt(),
                task.updatedAt()
        );

        var saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaRepository.findById(id)
                .map(TaskRepositoryAdapter::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(TaskRepositoryAdapter::toDomain)
                .toList();
    }

    @Override
    public List<Task> findAllByProjectId(Long projectId) {
        return jpaRepository.findAllByProjectIdOrderByColumnIdAscPositionAscIdAsc(projectId)
                .stream()
                .map(TaskRepositoryAdapter::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private static Task toDomain(TaskJpaEntity entity) {
        return new Task (
                entity.getId(),
                entity.getProjectId(),
                entity.getColumnId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPosition(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
