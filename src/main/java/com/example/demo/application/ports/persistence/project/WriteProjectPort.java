package com.example.demo.application.ports.persistence.project;

import com.example.demo.domain.managment.Project;

import java.util.Optional;

public interface WriteProjectPort {
    Project createNew(Project project);
    Optional<Project> update(Project project);
    void delete(Long id);
}
