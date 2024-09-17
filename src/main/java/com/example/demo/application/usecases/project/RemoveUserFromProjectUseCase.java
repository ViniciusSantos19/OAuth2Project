package com.example.demo.application.usecases.project;

import com.example.demo.domain.managment.Project;

public interface RemoveUserFromProjectUseCase {
    Project removeUser(Long id);
}
