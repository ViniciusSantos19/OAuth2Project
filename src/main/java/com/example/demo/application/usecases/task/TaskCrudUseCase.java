package com.example.demo.application.usecases.task;

import com.example.demo.domain.task.Task;

import java.util.Collection;

public interface TaskCrudUseCase {
    Task createNew(Task task);
    Task update(Task taks);
    void delete(Long id);
    Task findById(Long id);
    Collection<Task> findAllTasks();
}
