package com.example.demo.adapter.persistence.jpa.task;

import com.example.demo.adapter.persistence.jpa.model.TaskEntity;
import com.example.demo.adapter.persistence.jpa.repository.TaskRepository;
import com.example.demo.application.ports.persistence.task.ReadTaskPort;
import com.example.demo.domain.task.Task;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReadTaskAdapter implements ReadTaskPort {

    private final TaskRepository taskRepository;

    private final MapperFacade mapperJpaFacade;

    public ReadTaskAdapter(TaskRepository taskRepository, MapperFacade mapperJpaFacade) {
        this.taskRepository = taskRepository;
        this.mapperJpaFacade = mapperJpaFacade;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id)
                .map(taskEntity -> mapperJpaFacade.map(taskEntity, Task.class));
    }

    @Override
    public Page<Task> findPaginated(Pageable pageable) {
        Page<TaskEntity> tasks = taskRepository.findAll(pageable);
        return tasks.map(taskEntity -> mapperJpaFacade.map(taskEntity, Task.class));
    }
}
