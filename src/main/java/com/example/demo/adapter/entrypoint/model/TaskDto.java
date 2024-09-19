package com.example.demo.adapter.entrypoint.model;

import com.example.demo.domain.task.TaskPriority;
import com.example.demo.domain.task.TaskStatus;

import java.time.LocalDateTime;
import java.util.Set;

public record TaskDto(String title,
         String description,
         TaskStatus status,
         TaskPriority priority,
         LocalDateTime dueDate,
         LocalDateTime createdAt,
         LocalDateTime updatedAt,
         Set<UserSingUpDto>members) {
}
