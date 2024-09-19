package com.example.demo.application.ports.entrypoint.task;

import com.example.demo.adapter.entrypoint.model.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindTaskPort {
    TaskDto findById(Long id);
    Page<TaskDto> findAll(Pageable pageable);
}
