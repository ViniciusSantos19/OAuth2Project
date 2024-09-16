package com.example.demo.domain.task;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(LocalDateTime createdAt, TaskPriority priority, LocalDateTime dueDate, TaskStatus status, String description, String title, Long id) {
        this.createdAt = createdAt;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
        this.description = description;
        this.title = title;
        this.id = id;
    }
}
