package com.example.demo.domain.timetrack;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TimeEntry {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private Long taskId; // The ID of the task associated with this time entry
    private Long userId;

    public TimeEntry(Long id, LocalDateTime startTime, LocalDateTime endTime, String description, Long taskId, Long userId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.taskId = taskId;
        this.userId = userId;
    }
}
