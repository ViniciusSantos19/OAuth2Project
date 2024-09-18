package com.example.demo.application.usecases.project;

import com.example.demo.domain.managment.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProjectCrudUseCase {
    Project createNew(Project project);
    Project update(Project project);
    void delete(Long id);
    Project findById(Long id);
    Page<Project> findAllProject(Pageable pageable);
}
