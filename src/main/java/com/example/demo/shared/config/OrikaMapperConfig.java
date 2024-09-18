package com.example.demo.shared.config;

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
    MapperFacade mapperFacade(MapperFactory mapperFactory) {
        return mapperFactory.getMapperFacade();
    }

}
