package com.example.demo.adapter.persistence.jpa.model;

import com.example.demo.domain.user.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates ID
    private Long id;

    @Column(nullable = false, unique = true) // Ensures the username is unique and not null
    private String username;

    @Column(nullable = false, unique = true) // Ensures the email is unique and not null
    private String email;

    @Column(nullable = false) // Password cannot be null
    private String password;

    @Column(nullable = false)
    private String fullName;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<Role> roles;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String phoneNumber;

    private String profilePicture;

    @Column(nullable = false)
    private boolean status;

    // One-to-Many relationship with Project
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectEntity> projects;

    // One-to-Many relationship with Task
    @ManyToMany(mappedBy = "members")
    private Set<TaskEntity> tasks;

    // PrePersist and PreUpdate callbacks to set createdAt and updatedAt automatically
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }
}
