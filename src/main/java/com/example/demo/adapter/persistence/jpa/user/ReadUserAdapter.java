package com.example.demo.adapter.persistence.jpa.user;

import com.example.demo.adapter.persistence.jpa.model.UserEntity;
import com.example.demo.adapter.persistence.jpa.repository.UserRepository;
import com.example.demo.application.ports.persistence.user.ReadUserPort;
import com.example.demo.domain.user.User;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReadUserAdapter implements ReadUserPort {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public ReadUserAdapter(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Optional<User> findById(Long id) {
        return  userRepository.findById(id).map(user -> modelMapper.map(user, User.class));
    }

    @Override
    public Page<User> findPaginated(Pageable pageable) {
        Page<UserEntity> users = userRepository.findAll(pageable);

        return  users.map(userEntity -> modelMapper.map(userEntity, User.class));
    }
}
