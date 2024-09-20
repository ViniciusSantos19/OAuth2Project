package com.example.demo.adapter.entrypoint.project;

import com.example.demo.adapter.entrypoint.model.ProjectDto;
import com.example.demo.application.ports.entrypoint.project.ChangeProjectPort;
import com.example.demo.application.usecases.project.ProjectCrudUseCase;
import com.example.demo.domain.managment.Project;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChangePortAdapter implements ChangeProjectPort {

    private  final ProjectCrudUseCase projectCrudUseCase;
    
    private final ModelMapper modelMapper;


    public ChangePortAdapter(ProjectCrudUseCase projectCrudUseCase, ModelMapper modelMapper) {
        this.projectCrudUseCase = projectCrudUseCase;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        var projectDomain = modelMapper.map(projectDto, Project.class);
        var createdProject =  projectCrudUseCase.createNew(projectDomain);
        return modelMapper.map(createdProject, ProjectDto.class);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectUpdate) {
        var projectDomain = modelMapper.map(projectUpdate, Project.class);
        projectDomain.setId(id);
        projectCrudUseCase.update(projectDomain);
        return null;
    }

    @Override
    public void delete(Long id) {
        projectCrudUseCase.delete(id);
    }
}
