package com.example.demo.application.usecases.project;

import com.example.demo.domain.managment.Project;
import com.example.demo.domain.user.User;

public interface AddUserToProjectUseCase {
    Project addUser(User user);
}
