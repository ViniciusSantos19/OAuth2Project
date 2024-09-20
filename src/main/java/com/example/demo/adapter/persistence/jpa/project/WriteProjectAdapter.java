package com.example.demo.adapter.persistence.jpa.project;

import com.example.demo.adapter.persistence.jpa.model.ProjectEntity;
import com.example.demo.adapter.persistence.jpa.repository.ProjectRepository;
import com.example.demo.application.ports.persistence.project.WriteProjectPort;
import com.example.demo.domain.managment.Project;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WriteProjectAdapter implements WriteProjectPort {

    private final ProjectRepository projectRepository;

    private final ModelMapper modelMapper;

    public WriteProjectAdapter(ModelMapper modelMapper, ProjectRepository projectRepository) {
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createNew(Project project) {
        ProjectEntity projectEntity = modelMapper.map(project, ProjectEntity.class);
        ProjectEntity savedProjectEntity = projectRepository.save(projectEntity);
        return modelMapper.map(savedProjectEntity, Project.class);
    }

    @Override
    public Optional<Project> update(Project project) {
        return projectRepository.findById(project.getId())
                .map(existingEntity -> {
                    modelMapper.map(project, existingEntity);
                    ProjectEntity updatedEntity = projectRepository.save(existingEntity);
                    return modelMapper.map(updatedEntity, Project.class);
                });
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
