package com.example.backend.presentation.task;

import com.example.backend.application.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public GetTaskResponse create(@Valid @RequestBody CreateTaskRequest request) {
        var task = taskService.create(
                request.projectId(),
                request.columnId(),
                request.name(),
                request.description(),
                request.position()
        );

        return GetTaskResponse.from(task);
    }

    @GetMapping("/projects/{projectId}/tasks")
    public List<GetTaskResponse> getAllByProjectId(@PathVariable Long projectId) {
        return taskService.getAllByProjectId(projectId).stream()
                .map(GetTaskResponse::from)
                .toList();
    }

    @GetMapping("/tasks/{id}")
    public GetTaskResponse getById(@PathVariable Long id) {
        return GetTaskResponse.from(taskService.getById(id));
    }

    @PutMapping("/tasks/{id}/position")
    public GetTaskResponse updatePosition(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskPositionRequest request
    ) {
        return GetTaskResponse.from(
                taskService.updatePosition(id, request.columnId(), request.position())
        );
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }
}
