package com.example.demo.adapter.persistence.jpa.task;

import com.example.demo.adapter.persistence.jpa.model.TaskEntity;
import com.example.demo.adapter.persistence.jpa.repository.TaskRepository;
import com.example.demo.application.ports.persistence.task.WriteTaskPort;
import com.example.demo.domain.task.Task;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WriteTaskAdapter implements WriteTaskPort {

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper;

    public WriteTaskAdapter(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Task createNew(Task task) {
        TaskEntity taskEntity = modelMapper.map(task, TaskEntity.class);
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return modelMapper.map(savedTask, Task.class);
    }

    @Override
    public Optional<Task> update(Task task) {
        return taskRepository.findById(task.getId())
                .map(taskEntity -> {
                     modelMapper.map(task, taskEntity);
                    taskRepository.save(taskEntity);
                    return  modelMapper.map(taskEntity, Task.class);
                });
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
