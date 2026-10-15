package com.example.backend.infrastructure.persistence.projectColumn;

import jakarta.persistence.*;

import java.time.Instant;

@Entity()
@Table(name = "project_column")
public class ProjectColumnJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private int position;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected ProjectColumnJpaEntity() {

    }

    public ProjectColumnJpaEntity(
            Long id,
            Long projectId,
            String name,
            int position,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.position = position;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
