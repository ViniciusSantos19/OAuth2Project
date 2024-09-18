package com.example.demo.adapter.persistence.jpa.repository;

import com.example.demo.adapter.persistence.jpa.model.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
