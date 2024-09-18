package com.example.demo.application.ports.persistence.task;

import com.example.demo.domain.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReadTaskPort {
    Optional<Task> findById(Long id);
    Page<Task> findPaginated(Pageable pageable);
}
