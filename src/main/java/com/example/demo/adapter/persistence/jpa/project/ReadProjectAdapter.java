package com.example.demo.adapter.persistence.jpa.project;

import com.example.demo.adapter.persistence.jpa.model.ProjectEntity;
import com.example.demo.adapter.persistence.jpa.repository.ProjectRepository;
import com.example.demo.application.ports.persistence.project.ReadProjectPort;
import com.example.demo.domain.managment.Project;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReadProjectAdapter implements ReadProjectPort {

    private final ProjectRepository projectRepository;

    private final ModelMapper modelMapper;

    public ReadProjectAdapter(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository
                .findById(id).map(projectEntity -> modelMapper.
                map(projectEntity, Project.class));
    }

    @Override
    public Page<Project> findPaginated(Pageable pageable) {
        Page<ProjectEntity> projectEntities = projectRepository.findAll(pageable);
        return projectEntities.map(projectEntity -> modelMapper.map(projectEntity, Project.class));
    }

}
