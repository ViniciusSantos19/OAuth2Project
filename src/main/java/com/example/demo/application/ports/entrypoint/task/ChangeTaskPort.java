package com.example.demo.application.ports.entrypoint.task;

import com.example.demo.adapter.entrypoint.model.TaskDto;

public interface ChangeTaskPort {
    TaskDto save(TaskDto task);
    TaskDto update(Long id, TaskDto taskUpdate);
    void delete(Long id);
}
