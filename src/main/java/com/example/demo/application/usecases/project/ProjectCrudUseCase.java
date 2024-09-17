package com.example.demo.application.usecases.project;

import com.example.demo.domain.managment.Project;

import java.util.Collection;

public interface ProjectCrudUseCase {
    Project createNew(Project project);
    Project update(Project project);
    void delete(Long id);
    Project findById(Long id);
    Collection<Project> findAllProject();
}
