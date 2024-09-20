package com.example.demo.adapter.entrypoint.project;

import com.example.demo.adapter.entrypoint.model.ProjectDto;
import com.example.demo.application.ports.entrypoint.project.ChangeProjectPort;
import com.example.demo.application.ports.entrypoint.project.FindProjectPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/projects/v1")
public class ProjectController {

    private final ChangeProjectPort changeProjectPort;

    private final FindProjectPort findProjectPort;


    public ProjectController(ChangeProjectPort changeProjectPort, FindProjectPort findProjectPort) {
        this.changeProjectPort = changeProjectPort;
        this.findProjectPort = findProjectPort;
    }

    @GetMapping
    public ResponseEntity<Page<ProjectDto>> getAllProjects(@PageableDefault(size = 10) Pageable pageable) {
        Page<ProjectDto> projects = findProjectPort.findAll(pageable);
        return  ResponseEntity.ok().body(projects);
    }

    @GetMapping("/{project_id}")
    public ResponseEntity<ProjectDto> findById(@PathVariable("project_id") Long id) {
        var projectDto = findProjectPort.findById(id);
        return  ResponseEntity.ok().body(projectDto);
    }
}
