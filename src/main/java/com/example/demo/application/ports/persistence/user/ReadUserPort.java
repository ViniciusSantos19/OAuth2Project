package com.example.demo.application.ports.persistence.user;

import com.example.demo.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReadUserPort {
    Optional<User> findById(Long id);
    Page<User> findPaginated(Pageable pageable);
}
