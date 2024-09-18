package com.example.demo.application.usecases.user;

import com.example.demo.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserCrudUseCase {
    User createNew(User user);
    User update(User user);
    void delete(Long id);
    User findById(Long id);
    Page<User> findAllUser(Pageable pageable);
}
