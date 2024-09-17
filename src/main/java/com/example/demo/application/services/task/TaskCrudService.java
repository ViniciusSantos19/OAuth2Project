package com.example.demo.application.services.task;

import com.example.demo.application.ports.persistence.task.ReadTaskPort;
import com.example.demo.application.ports.persistence.task.WriteTaskPort;
import com.example.demo.application.usecases.task.TaskCrudUseCase;
import com.example.demo.domain.exceptions.NotFoundDomainException;
import com.example.demo.domain.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskCrudService implements TaskCrudUseCase {

    @Autowired
    private WriteTaskPort writeTaskPort;

    @Autowired
    private ReadTaskPort readTaskPort;

    @Override
    public Task createNew(Task task) {
        return this.writeTaskPort.createNew(task);
    }

    @Override
    public Task update(Task taks) {
        return writeTaskPort.update(taks).orElseThrow(NotFoundDomainException::new);
    }

    @Override
    public void delete(Long id) {
        readTaskPort.findById().orElseThrow(NotFoundDomainException::new);

    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Collection<Task> findAllTasks() {
        return  readTaskPort.getAll();
    }
}
