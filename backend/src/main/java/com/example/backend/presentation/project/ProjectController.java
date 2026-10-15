package com.example.backend.presentation.project;

import com.example.backend.application.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetProjectResponse create(
            @Valid
            @RequestBody
            CreateProjectRequest request
    ) {

        var project = projectService.create(request.name());

        return GetProjectResponse.from(project);
    }

    @GetMapping
    public List<GetProjectResponse> getAll() {
        var projects = projectService.getAll();

        return projects.stream()
                .map(GetProjectResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public GetProjectResponse getById(@PathVariable Long id) {
        var project = projectService.getById(id);

        return GetProjectResponse.from(project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        projectService.deleteById(id);
    }

}
