package com.example.demo.adapter.persistence.jpa.user;

import com.example.demo.adapter.persistence.jpa.model.UserEntity;
import com.example.demo.adapter.persistence.jpa.repository.UserRepository;
import com.example.demo.application.ports.persistence.user.WriteUserPort;
import com.example.demo.domain.user.User;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WriteUserAdapter implements WriteUserPort {

    private  final UserRepository userRepository;

    private final MapperFacade mapperJpaFacade;

    public WriteUserAdapter(UserRepository userRepository, MapperFacade mapperJpaFacade) {
        this.userRepository = userRepository;
        this.mapperJpaFacade = mapperJpaFacade;
    }


    @Override
    public User createNew(User user) {
        UserEntity userEntity = mapperJpaFacade.map(user, UserEntity.class);
        UserEntity savedUser = userRepository.save(userEntity);
        return mapperJpaFacade.map(savedUser, User.class);
    }

    @Override
    public Optional<User> update(User user) {
        return  userRepository.findById(user.getId())
                .map(userEntity -> {
                    mapperJpaFacade.map(user, userEntity);
                    userRepository.save(userEntity);
                    return  mapperJpaFacade.map(userEntity, User.class);
                });
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
