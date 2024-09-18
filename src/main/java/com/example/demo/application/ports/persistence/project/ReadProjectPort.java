package com.example.demo.application.ports.persistence.project;

import com.example.demo.domain.managment.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface ReadProjectPort {
    Optional<Project> findById(Long id);
    Page<Project> findPaginated(Pageable pageable);
}
