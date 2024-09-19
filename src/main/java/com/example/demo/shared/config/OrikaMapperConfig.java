package com.example.demo.shared.config;

import com.example.demo.adapter.entrypoint.model.*;
import com.example.demo.adapter.persistence.jpa.model.ProjectEntity;
import com.example.demo.adapter.persistence.jpa.model.TaskEntity;
import com.example.demo.adapter.persistence.jpa.model.UserEntity;
import com.example.demo.domain.managment.Project;
import com.example.demo.domain.task.Task;
import com.example.demo.domain.user.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaMapperConfig {

    @Bean
    MapperFactory mapperJpaFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(UserEntity.class, User.class)
                .field("roles", "role")
                .byDefault()
                .register();

        mapperFactory.classMap(ProjectEntity.class, Project.class)
                .byDefault() // Automatic field name mapping
                .register();

        mapperFactory.classMap(TaskEntity.class, Task.class)
                .byDefault()
                .register();

        return mapperFactory;
    }

    @Bean
    MapperFacade mapperJpaFacade(MapperFactory mapperJpaFactory) {
        return mapperJpaFactory.getMapperFacade();
    }

    @Bean
    MapperFactory mapperEntryPointFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(UserDto.class, User.class)
                .byDefault()
                .register();

        mapperFactory.classMap(UserLoginDto.class, User.class)
                .byDefault()
                .register();

        mapperFactory.classMap(UserSingUpDto.class, User.class)
                        .byDefault()
                        .register();

        mapperFactory.classMap(ProjectDto.class, Project.class)
                .byDefault()
                .register();

        mapperFactory.classMap(TaskDto.class, Task.class)
                .byDefault()
                .register();

        return mapperFactory;
    }

    @Bean
    MapperFacade mapperFacadeEntryPoint(MapperFactory mapperEntryPointFactory) {
        return mapperEntryPointFactory.getMapperFacade();
    }

}
