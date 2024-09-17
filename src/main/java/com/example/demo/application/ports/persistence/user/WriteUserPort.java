package com.example.demo.application.ports.persistence.user;

import com.example.demo.domain.user.User;

import java.util.Optional;

public interface WriteUserPort {
    User createNew(User user);
    Optional<User> update(User user);
    void delete(Long id);
}
