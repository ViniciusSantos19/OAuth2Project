package com.example.demo.application.ports.persistence.project;

import com.example.demo.domain.managment.Project;

import java.util.Collection;
import java.util.Optional;

public interface ReadProjectPort {
    Optional<Project> findById(Long id);
    Collection<Project> getAll();
}
