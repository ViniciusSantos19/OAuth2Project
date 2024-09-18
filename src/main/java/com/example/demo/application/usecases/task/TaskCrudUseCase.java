package com.example.demo.application.usecases.task;

import com.example.demo.domain.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TaskCrudUseCase {
    Task createNew(Task task);
    Task update(Task taks);
    void delete(Long id);
    Task findById(Long id);
    Page<Task> findAllTasks(Pageable pageable);
}
