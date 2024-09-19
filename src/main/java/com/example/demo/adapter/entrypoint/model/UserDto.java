package com.example.demo.adapter.entrypoint.model;

import com.example.demo.domain.user.Role;

import java.util.List;
import java.util.Set;

public record UserDto(String username,
                      String fullName,
                      Set<Role> roles,
                      String phoneNumber,
                      String profilePicture,
                      List<ProjectDto> projects,
                      List<TaskDto> tasks) {
}
