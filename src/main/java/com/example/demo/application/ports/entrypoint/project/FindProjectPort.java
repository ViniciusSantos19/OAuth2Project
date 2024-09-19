package com.example.demo.application.ports.entrypoint.project;

import com.example.demo.adapter.entrypoint.model.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProjectPort {
    ProjectDto findById(Long id);
    Page<ProjectDto> findAll(Pageable pageable);
}
