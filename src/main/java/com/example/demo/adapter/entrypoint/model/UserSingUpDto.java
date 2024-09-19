package com.example.demo.adapter.entrypoint.model;

import com.example.demo.domain.user.Role;

import java.util.Set;

public record UserSingUpDto(String username,
                            String email,
                            String password,
                            String fullName,
                            Set<Role>roles) {
}
