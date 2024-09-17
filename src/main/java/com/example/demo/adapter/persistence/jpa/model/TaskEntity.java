package com.example.demo.adapter.persistence.jpa.model;

import com.example.demo.domain.task.TaskPriority;
import com.example.demo.domain.task.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private LocalDateTime dueDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "task_users", // Join table name
            joinColumns = @JoinColumn(name = "task_id"), // Column for this entity's ID
            inverseJoinColumns = @JoinColumn(name = "user_id") // Column for the associated entity's ID
    )
    private Set<UserEntity> members;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public TaskEntity(Set<UserEntity> members, LocalDateTime dueDate, TaskPriority priority, TaskStatus status, String description, String title) {
        this.members = members;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.description = description;
        this.title = title;
    }
}
