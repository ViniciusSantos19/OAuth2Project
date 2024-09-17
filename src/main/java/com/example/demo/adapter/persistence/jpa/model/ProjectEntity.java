package com.example.demo.adapter.persistence.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // One-to-Many relationship with Milestone
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MilestoneEntity> milestones;

    // One-to-Many relationship with Task
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskEntity> tasks;

    // Many-to-One relationship with User (Manager)
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private UserEntity manager;

    // Many-to-Many relationship with User (Members)
    @ManyToMany
    @JoinTable(
            name = "project_users", // Join table name
            joinColumns = @JoinColumn(name = "project_id"), // Column for this entity's ID
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

    public ProjectEntity(List<MilestoneEntity> milestones, Set<UserEntity> members, UserEntity manager, List<TaskEntity> tasks, LocalDateTime endDate, LocalDateTime startDate, String description, String name) {
        this.milestones = milestones;
        this.members = members;
        this.manager = manager;
        this.tasks = tasks;
        this.endDate = endDate;
        this.startDate = startDate;
        this.description = description;
        this.name = name;
    }
}
