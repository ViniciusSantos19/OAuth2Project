package com.example.demo.adapter.persistence.jpa.repository;

import com.example.demo.adapter.persistence.jpa.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
