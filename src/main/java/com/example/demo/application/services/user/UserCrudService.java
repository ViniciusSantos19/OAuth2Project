package com.example.demo.application.services.user;

import com.example.demo.application.ports.persistence.user.ReadUserPort;
import com.example.demo.application.ports.persistence.user.WriteUserPort;
import com.example.demo.application.usecases.user.UserCrudUseCase;
import com.example.demo.domain.exceptions.NotFoundDomainException;
import com.example.demo.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserCrudService implements UserCrudUseCase {

    @Autowired
    private WriteUserPort writeUserPort;

    @Autowired
    private ReadUserPort readUserPort;

    @Override
    public User createNew(User user) {
        return  writeUserPort.createNew(user);
    }

    @Override
    public User update(User user) {
        return writeUserPort.update(user).orElseThrow(NotFoundDomainException::new);
    }

    @Override
    public void delete(Long id) {
        readUserPort.findById(id).orElseThrow(NotFoundDomainException::new);
        writeUserPort.delete(id);
    }

    @Override
    public User findById(Long id) {
        return readUserPort.findById(id).orElseThrow(NotFoundDomainException::new);
    }

    @Override
    public Collection<User> findAllUser() {
        return readUserPort.findAllUsers();
    }
}
