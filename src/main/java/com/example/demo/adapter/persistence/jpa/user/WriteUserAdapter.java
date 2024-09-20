package com.example.demo.adapter.persistence.jpa.user;

import com.example.demo.adapter.persistence.jpa.model.UserEntity;
import com.example.demo.adapter.persistence.jpa.repository.UserRepository;
import com.example.demo.application.ports.persistence.user.WriteUserPort;
import com.example.demo.domain.user.User;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WriteUserAdapter implements WriteUserPort {

    private  final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public WriteUserAdapter(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public User createNew(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        UserEntity savedUser = userRepository.save(userEntity);
        return modelMapper.map(savedUser, User.class);
    }

    @Override
    public Optional<User> update(User user) {
        return  userRepository.findById(user.getId())
                .map(userEntity -> {
                    modelMapper.map(user, userEntity);
                    userRepository.save(userEntity);
                    return  modelMapper.map(userEntity, User.class);
                });
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
