package com.example.demo.adapter.persistence.jpa.project;

import com.example.demo.adapter.persistence.jpa.model.ProjectEntity;
import com.example.demo.adapter.persistence.jpa.repository.ProjectRepository;
import com.example.demo.application.ports.persistence.project.WriteProjectPort;
import com.example.demo.domain.managment.Project;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WriteProjectAdapter implements WriteProjectPort {

    private final ProjectRepository projectRepository;

    private final MapperFacade mapperFacade;

    public WriteProjectAdapter(MapperFacade mapperFacade, ProjectRepository projectRepository) {
        this.mapperFacade = mapperFacade;
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createNew(Project project) {
        ProjectEntity projectEntity = mapperFacade.map(project, ProjectEntity.class);
        ProjectEntity savedProjectEntity = projectRepository.save(projectEntity);
        return mapperFacade.map(savedProjectEntity, Project.class);
    }

    @Override
    public Optional<Project> update(Project project) {
        return projectRepository.findById(project.getId())
                .map(existingEntity -> {
                    mapperFacade.map(project, existingEntity);
                    ProjectEntity updatedEntity = projectRepository.save(existingEntity);
                    return mapperFacade.map(updatedEntity, Project.class);
                });
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
