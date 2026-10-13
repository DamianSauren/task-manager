package com.example.backend.infrastructure.persistence.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTaskRepository
        extends JpaRepository<TaskJpaEntity, Long> {
}
