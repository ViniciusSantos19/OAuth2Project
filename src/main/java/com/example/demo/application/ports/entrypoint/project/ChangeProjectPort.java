package com.example.demo.application.ports.entrypoint.project;

import com.example.demo.adapter.entrypoint.model.ProjectDto;

public interface ChangeProjectPort {
    ProjectDto save(ProjectDto projectDto);
    ProjectDto update(Long id, ProjectDto projectUpdate);
    void delete(Long id);
}
