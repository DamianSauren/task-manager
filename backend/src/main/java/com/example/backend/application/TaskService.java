package com.example.backend.application;

import com.example.backend.domain.project.ProjectNotFoundException;
import com.example.backend.domain.project.ProjectRepository;
import com.example.backend.domain.projectColumn.ProjectColumnNotFoundException;
import com.example.backend.domain.projectColumn.ProjectColumnRepository;
import com.example.backend.domain.task.Task;
import com.example.backend.domain.task.TaskNotFoundException;
import com.example.backend.domain.task.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final ProjectRepository projectRepository;
    private final ProjectColumnRepository projectColumnRepository;
    private final TaskRepository taskRepository;

    public TaskService(
            ProjectRepository projectRepository,
            ProjectColumnRepository projectColumnRepository,
            TaskRepository taskRepository
    ) {
        this.projectRepository = projectRepository;
        this.projectColumnRepository = projectColumnRepository;
        this.taskRepository = taskRepository;
    }

    public Task create(
            Long projectId,
            Long columnId,
            String name,
            String description,
            int position
    ) {
        validateProjectExists(projectId);
        validateColumnBelongsToProject(projectId, columnId);

        Instant now = Instant.now();
        Task task = new Task(
                null,
                projectId,
                columnId,
                name,
                description,
                position,
                now,
                now
        );

        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Task> getAllByProjectId(Long projectId) {
        validateProjectExists(projectId);
        return taskRepository.findAllByProjectId(projectId);
    }

    public Task updatePosition(Long id, Long columnId, int position) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        validateColumnBelongsToProject(task.projectId(), columnId);

        Task updatedTask = new Task(
                task.id(),
                task.projectId(),
                columnId,
                task.name(),
                task.description(),
                position,
                task.createdAt(),
                Instant.now()
        );

        return taskRepository.save(updatedTask);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    private void validateProjectExists(Long projectId) {
        if (projectId == null || projectId <= 0) {
            throw new IllegalArgumentException("Project ID must be greater than 0.");
        }
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException(projectId);
        }
    }

    private void validateColumnBelongsToProject(Long projectId, Long columnId) {
        if (columnId == null || columnId <= 0) {
            throw new IllegalArgumentException("Column ID must be greater than 0.");
        }
        boolean columnBelongsToProject = projectColumnRepository.findAllByProjectId(projectId)
                .stream()
                .anyMatch(column -> column.id().equals(columnId));
        if (!columnBelongsToProject) {
            throw new ProjectColumnNotFoundException(columnId);
        }
    }
}
