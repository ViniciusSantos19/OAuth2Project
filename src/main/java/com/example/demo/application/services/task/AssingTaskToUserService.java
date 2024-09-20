package com.example.demo.application.services.task;

import com.example.demo.application.ports.persistence.task.ReadTaskPort;
import com.example.demo.application.ports.persistence.task.WriteTaskPort;
import com.example.demo.application.usecases.task.AssignUserToTaskUseCase;
import com.example.demo.domain.exceptions.NotFoundDomainException;
import com.example.demo.domain.task.Task;
import com.example.demo.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssingTaskToUserService implements AssignUserToTaskUseCase {

    @Autowired
    private WriteTaskPort writeTaskPort;

    @Autowired
    private ReadTaskPort readTaskPort;

    @Override
    public Task assing(User user, Long id) {
        var task = readTaskPort.findById(id).orElseThrow(NotFoundDomainException::new);
        task.getMembers().add(user);
        return writeTaskPort.update(task).orElseThrow(NotFoundDomainException::new);
    }

    @Override
    public void removeUser(Long id, Long taskId) {
        var task = readTaskPort.findById(id).orElseThrow(NotFoundDomainException::new);
        task.getMembers().removeIf(user -> user.getId().equals(id));
         writeTaskPort.update(task).orElseThrow(NotFoundDomainException::new);
    }
}
