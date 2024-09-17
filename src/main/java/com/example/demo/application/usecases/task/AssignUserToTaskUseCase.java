package com.example.demo.application.usecases.task;

import com.example.demo.domain.task.Task;
import com.example.demo.domain.user.User;

public interface AssignUserToTaskUseCase {
    Task assing(User user, Long id);
    void removeUser(Long id, Long taskId);
}
