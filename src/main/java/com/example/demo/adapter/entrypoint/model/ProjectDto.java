package com.example.demo.adapter.entrypoint.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record ProjectDto( String name,
         String description,
         LocalDateTime startDate,
         LocalDateTime endDate,
         LocalDateTime createdAt,
         LocalDateTime updatedAt,
         List<MilestoneDto>milestones,
         List<TaskDto> tasks,
         UserSingUpDto manager,
         Set<UserSingUpDto>members) {
}
