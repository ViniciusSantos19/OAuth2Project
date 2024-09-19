package com.example.demo.application.ports.entrypoint.user;

import com.example.demo.adapter.entrypoint.model.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindUserPort {
    UserDto findById(Long id);
    Page<UserDto> findAll(Pageable pageable);
}
