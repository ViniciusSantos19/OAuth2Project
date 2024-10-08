package com.example.demo.domain.user;

import com.example.demo.domain.managment.Project;
import com.example.demo.domain.task.Task;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private Set<Role> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String phoneNumber;
    private String profilePicture;
    private boolean status;

    private List<Project> projects;
    private List<Task> tasks;

    public User(Long id, String email, String username, String password, String fullName, Set<Role> roles, LocalDateTime createdAt, String phoneNumber, String profilePicture, boolean status, List<Project> projects, List<Task> tasks) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.roles = roles;
        this.createdAt = createdAt;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePicture;
        this.status = status;
        this.projects = projects;
        this.tasks = tasks;
    }
}
