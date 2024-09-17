package com.example.demo.application.ports.persistence.task;

import com.example.demo.domain.task.Task;

import java.util.Collection;
import java.util.Optional;

public interface ReadTaskPort {
    Optional<Task> findById();
    Collection<Task> getAll();
}
