package com.example.demo.application.services.project;

import com.example.demo.application.ports.persistence.project.ReadProjectPort;
import com.example.demo.application.ports.persistence.project.WriteProjectPort;
import com.example.demo.application.usecases.project.ProjectCrudUseCase;
import com.example.demo.domain.exceptions.NotFoundDomainException;
import com.example.demo.domain.managment.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectCrudService implements ProjectCrudUseCase {

    @Autowired
    private WriteProjectPort writeProjectPort;

    @Autowired
    private ReadProjectPort readProjectPort;

    @Override
    public Project createNew(Project project) {
        return writeProjectPort.createNew(project);
    }

    @Override
    public Project update(Project project) {
        return writeProjectPort.update(project).orElseThrow(NotFoundDomainException::new);
    }

    @Override
    public void delete(Long id) {
        readProjectPort.findById(id).orElseThrow(NotFoundDomainException::new);
        writeProjectPort.delete(id);
    }

    @Override
    public Project findById(Long id) {
        return readProjectPort.findById(id).orElseThrow(NotFoundDomainException::new);
    }

    @Override
    public Page<Project> findAllProject(Pageable pageable) {
        return  readProjectPort.findPaginated(pageable);
    }
}
