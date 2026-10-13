package com.example.backend.infrastructure.persistence.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProjectRepository
        extends JpaRepository<ProjectJpaEntity, Long> {
}
