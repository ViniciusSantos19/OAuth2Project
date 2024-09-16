package com.example.demo.domain.managment;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProjectGroup {
    private Long id;
    private String name;
    private String description;
    private List<Project> projects;
}
