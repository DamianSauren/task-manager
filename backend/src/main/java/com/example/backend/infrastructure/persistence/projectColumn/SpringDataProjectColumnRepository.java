package com.example.backend.infrastructure.persistence.projectColumn;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataProjectColumnRepository
        extends JpaRepository<ProjectColumnJpaEntity, Long> {

    List<ProjectColumnJpaEntity> findAllByProjectId(Long projectId);

}
