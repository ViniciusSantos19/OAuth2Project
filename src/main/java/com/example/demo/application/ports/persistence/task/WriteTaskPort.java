package com.example.demo.application.ports.persistence.task;

import com.example.demo.domain.task.Task;

import java.util.Optional;

public interface WriteTaskPort {
    Task createNew(Task task);
    Optional<Task> update(Task task);
    void delete(Long id);
}
