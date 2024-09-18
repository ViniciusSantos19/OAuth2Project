package com.example.demo.adapter.persistence.jpa.task;

import com.example.demo.adapter.persistence.jpa.model.TaskEntity;
import com.example.demo.adapter.persistence.jpa.repository.TaskRepository;
import com.example.demo.application.ports.persistence.task.WriteTaskPort;
import com.example.demo.domain.task.Task;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WriteTaskAdapter implements WriteTaskPort {

    private final TaskRepository taskRepository;

    private final MapperFacade mapperFacade;

    public WriteTaskAdapter(TaskRepository taskRepository, MapperFacade mapperFacade) {
        this.taskRepository = taskRepository;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public Task createNew(Task task) {
        TaskEntity taskEntity = mapperFacade.map(task, TaskEntity.class);
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return mapperFacade.map(savedTask, Task.class);
    }

    @Override
    public Optional<Task> update(Task task) {
        return taskRepository.findById(task.getId())
                .map(taskEntity -> {
                     mapperFacade.map(task, taskEntity);
                    taskRepository.save(taskEntity);
                    return  mapperFacade.map(taskEntity, Task.class);
                });
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
