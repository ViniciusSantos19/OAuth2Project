package com.example.demo.domain.timetrack;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Deadline {
    private Long id;
    private LocalDateTime dueDate;
    private String description;
    private boolean isMet;
    private Long taskId;

    public Deadline(Long id, LocalDateTime dueDate, String description, boolean isMet, Long taskId) {
        this.id = id;
        this.dueDate = dueDate;
        this.description = description;
        this.isMet = isMet;
        this.taskId = taskId;
    }
}
