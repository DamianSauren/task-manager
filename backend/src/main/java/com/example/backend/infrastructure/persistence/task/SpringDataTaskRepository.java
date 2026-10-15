package com.example.backend.infrastructure.persistence.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataTaskRepository
        extends JpaRepository<TaskJpaEntity, Long> {

    List<TaskJpaEntity> findAllByProjectIdOrderByColumnIdAscPositionAscIdAsc(Long projectId);
}
