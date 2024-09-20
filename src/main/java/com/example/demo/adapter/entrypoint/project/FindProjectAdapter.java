package com.example.demo.adapter.entrypoint.project;

import com.example.demo.adapter.entrypoint.model.ProjectDto;
import com.example.demo.application.ports.entrypoint.project.FindProjectPort;
import com.example.demo.application.usecases.project.ProjectCrudUseCase;
import com.example.demo.domain.managment.Project;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class FindProjectAdapter implements FindProjectPort {

    private  final ProjectCrudUseCase projectCrudUseCase;

    private final ModelMapper modelMapper;

    public FindProjectAdapter(ProjectCrudUseCase projectCrudUseCase, ModelMapper modelMapper) {
        this.projectCrudUseCase = projectCrudUseCase;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProjectDto findById(Long id) {
        var projectDomain = projectCrudUseCase.findById(id);
        return modelMapper.map(projectDomain, ProjectDto.class);
    }

    @Override
    public Page<ProjectDto> findAll(Pageable pageable) {
        Page<Project> projectsDomain = projectCrudUseCase.findAllProject(pageable);
        return projectsDomain.map(project -> modelMapper
                .map(project, ProjectDto.class));
    }
}
