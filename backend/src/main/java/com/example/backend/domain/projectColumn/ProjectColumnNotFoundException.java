package com.example.backend.domain.projectColumn;

public class ProjectColumnNotFoundException extends RuntimeException {
    public ProjectColumnNotFoundException(Long id) {
        super("ProjectColumn not found: " + id);
    }
}
