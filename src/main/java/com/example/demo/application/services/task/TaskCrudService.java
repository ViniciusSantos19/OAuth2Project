package com.example.demo.application.services.task;

import com.example.demo.application.ports.persistence.task.ReadTaskPort;
import com.example.demo.application.ports.persistence.task.WriteTaskPort;
import com.example.demo.application.usecases.task.TaskCrudUseCase;
import com.example.demo.domain.exceptions.NotFoundDomainException;
import com.example.demo.domain.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        readTaskPort.findById(id).orElseThrow(NotFoundDomainException::new);

    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Page<Task> findAllTasks(Pageable pageable) {
        return  readTaskPort.findPaginated(pageable);
    }
}
