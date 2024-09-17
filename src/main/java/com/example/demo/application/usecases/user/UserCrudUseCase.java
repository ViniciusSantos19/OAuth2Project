package com.example.demo.application.usecases.user;

import com.example.demo.domain.user.User;

import java.util.Collection;

public interface UserCrudUseCase {
    User createNew(User user);
    User update(User user);
    void delete(Long id);
    User findById(Long id);
    Collection<User> findAllUser();
}
