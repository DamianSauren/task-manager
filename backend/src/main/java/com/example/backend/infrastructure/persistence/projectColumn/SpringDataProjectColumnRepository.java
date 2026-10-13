package com.example.backend.infrastructure.persistence.projectColumn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProjectColumnRepository
        extends JpaRepository<ProjectJpaEntity, Long> {
}
