package com.example.backend.presentation.projectColumn;

import com.example.backend.application.ProjectColumnService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectColumnController {

    private final ProjectColumnService projectColumnService;

    public ProjectColumnController(ProjectColumnService projectColumnService) {
        this.projectColumnService = projectColumnService;
    }

    @PostMapping("/projects/{projectId}/columns")
    @ResponseStatus(HttpStatus.CREATED)
    public GetProjectColumnResponse create(
            @PathVariable Long projectId,
            @Valid @RequestBody CreateProjectColumnRequest request
    ) {
        var projectColumn = projectColumnService.create(
                projectId,
                request.name(),
                request.position()
        );

        return GetProjectColumnResponse.from(projectColumn);
    }

    @GetMapping("/projects/{projectId}/columns")
    public List<GetProjectColumnResponse> getByProjectId(@PathVariable Long projectId) {
        return projectColumnService.getAllByProjectId(projectId).stream()
                .map(GetProjectColumnResponse::from)
                .toList();
    }


    @DeleteMapping("/projects/{projectId}/columns/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        projectColumnService.deleteById(id);
    }
}
