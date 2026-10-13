package com.example.backend.infrastructure.persistence.task;

import jakarta.persistence.*;

import java.time.Instant;

@Entity()
@Table(name = "tasks")
public class TaskJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "column_id", nullable = false)
    private Long columnId;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 600)
    private String description;

    @Column(nullable = false)
    private int position;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected TaskJpaEntity() {

    }

    public TaskJpaEntity(
            Long id,
            Long projectId,
            Long columnId,
            String name,
            String description,
            int position,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.projectId = projectId;
        this.columnId = columnId;
        this.name = name;
        this.description = description;
        this.position = position;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() { return projectId; }

    public Long getColumnId() { return columnId;  }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public int getPosition() { return position; }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
