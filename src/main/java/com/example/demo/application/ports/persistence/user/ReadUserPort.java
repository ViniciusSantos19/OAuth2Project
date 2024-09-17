package com.example.demo.application.ports.persistence.user;

import com.example.demo.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface ReadUserPort {
    Optional<User> findById(Long id);
    List<User> findAllUsers();
}
