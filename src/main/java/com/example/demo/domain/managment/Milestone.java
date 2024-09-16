package com.example.demo.domain.managment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Milestone {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime dueDate;
    private boolean achieved;
}
