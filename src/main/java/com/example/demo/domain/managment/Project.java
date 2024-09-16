package com.example.demo.domain.managment;

import com.example.demo.domain.task.Task;
import com.example.demo.domain.user.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class Project {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Milestone> milestones;
    private List<Task> tasks;
    private User manager;
}
