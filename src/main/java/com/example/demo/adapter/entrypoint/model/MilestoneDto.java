package com.example.demo.adapter.entrypoint.model;

import java.time.LocalDateTime;

public record MilestoneDto(String name,
         String description,
         LocalDateTime dueDate,
         boolean achieved) {
}
