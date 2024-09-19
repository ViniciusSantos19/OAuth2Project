package com.example.demo.application.ports.entrypoint.user;

import com.example.demo.adapter.entrypoint.model.UserDto;
import com.example.demo.adapter.entrypoint.model.UserSingUpDto;

public interface ChangeUserPort {
    UserDto save(UserSingUpDto userDto);
    UserDto update(Long id, UserSingUpDto userDto);
    void delete(Long id);
}
