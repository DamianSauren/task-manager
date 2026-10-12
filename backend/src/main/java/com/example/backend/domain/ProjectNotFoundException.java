package com.example.backend.domain;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Long id) {
        super("Project not found: " + id);
    }
}
