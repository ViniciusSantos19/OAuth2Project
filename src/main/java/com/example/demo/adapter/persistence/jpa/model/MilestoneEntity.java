package com.example.demo.adapter.persistence.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "milestones")
public class MilestoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private LocalDateTime dueDate;

    @Column(nullable = false)
    private boolean achieved;

    public MilestoneEntity(String name, String description, LocalDateTime dueDate, boolean achieved) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.achieved = achieved;
    }
}
